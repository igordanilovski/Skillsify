package com.app.skillsify.services.impl;

import com.app.skillsify.models.Course;
import com.app.skillsify.models.CourseAnnouncement;
import com.app.skillsify.repositories.CourseAnnouncementsRepository;
import com.app.skillsify.repositories.CourseRepository;
import com.app.skillsify.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseAnnouncementsRepository courseAnnouncementsRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CourseAnnouncementsRepository courseAnnouncementsRepository) {
        this.courseRepository = courseRepository;
        this.courseAnnouncementsRepository = courseAnnouncementsRepository;
    }

//    public List<CourseAnnouncement> addRecursively(CourseAnnouncement courseAnnouncement) {
//        List<CourseAnnouncement> listToAdd = new ArrayList<>();
//
//        if (courseAnnouncement.getChildAnnouncements().size() != 0) {
//            courseAnnouncement.getChildAnnouncements().forEach(obj -> {
//                addRecursively(obj);
//                listToAdd.add(obj);
//            });
//        } else {
//            return listToAdd;
//        }
//        return listToAdd;
//    }

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
}
