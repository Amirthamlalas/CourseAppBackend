package com.nest.courseapp_backend.controller;

import com.nest.courseapp_backend.dao.CourseDao;
import com.nest.courseapp_backend.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String AddCourse(@RequestBody Course c){
        System.out.println(c.getCourseTitle().toString());
        dao.save(c);

        return "course added successffully";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Course> view(){
        return (List<Course>) dao.findAll();
    }
}
