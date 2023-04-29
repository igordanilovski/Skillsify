package com.app.skillsify.services.impl;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.CourseDto;
import com.app.skillsify.models.dto.EnrollmentDto;
import com.app.skillsify.repositories.CourseAnnouncementsRepository;
import com.app.skillsify.repositories.CourseRepository;
import com.app.skillsify.repositories.UserRepository;
import com.app.skillsify.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseAnnouncementsRepository courseAnnouncementsRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, CourseAnnouncementsRepository courseAnnouncementsRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.courseAnnouncementsRepository = courseAnnouncementsRepository;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = this.courseRepository.findAll();
        //TODO: [Igor] Refactor this
        List<CourseAnnouncement> temp = new ArrayList<>();
        List<CourseAnnouncement> root = new ArrayList<>();
        Map<Long, CourseAnnouncement> rootMap = new HashMap<>();

        courses.forEach(course -> {
            //course.setCourseAnnouncements(this.courseAnnouncementsRepository.findByCourseIdWhereParentAnnouncementIsNull(course.getId()));

        });
        temp = courses.get(0).getCourseAnnouncements().stream().toList();
        temp.forEach(obj -> {
            rootMap.put(obj.getId(), obj);
        });

        temp.forEach(obj -> {
            if (obj.getParent_announcement_id() == null) {
                root.add(obj);
            } else {
                CourseAnnouncement tempAnnouncement = rootMap.get(obj.getParent_announcement_id());
                if (tempAnnouncement != null) {
                    tempAnnouncement.setChildAnnouncements(new ArrayList<>());
                    tempAnnouncement.getChildAnnouncements().add(obj);
                }
            }
        });
        courses.get(0).setCourseAnnouncements(root);

        return courses;
    }

    @Override
    public Optional<Course> findByName(String name) {
        return this.courseRepository.findByName(name);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

    public Course create(CourseDto courseDto) {
        Course c = new Course();

        User userCreator = this.userRepository.findById(courseDto.getUserId()).get();

        c.setName(courseDto.getName());
        c.setAbout(courseDto.getAbout());
        c.setCreator(userCreator);
        c.setCreatedAt(new Date());
        c.setSkillRequired(courseDto.getSkill());

        return this.courseRepository.save(c);
    }

    public Course edit(Long id, CourseDto courseDto) {
        Course c = this.courseRepository.findById(id).get();

        c.setName(courseDto.getName());
        c.setAbout(courseDto.getAbout());
        c.setSkillRequired(courseDto.getSkill());
        c.setUpdatedAt(new Date());

        return this.courseRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Course enrollUser(EnrollmentDto enrollmentDto) {
        Course course = this.courseRepository.findById(enrollmentDto.getCourseId()).orElseThrow();
        course.getParticipants().add(this.userRepository.findByUsername(enrollmentDto.getUsername()).orElseThrow());
        return this.courseRepository.save(course);
    }
}
