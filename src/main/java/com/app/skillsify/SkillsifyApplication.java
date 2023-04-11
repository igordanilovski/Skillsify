package com.app.skillsify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.app.skillsify", "com.app.skillsify"})
public class SkillsifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillsifyApplication.class, args);
    }

}
