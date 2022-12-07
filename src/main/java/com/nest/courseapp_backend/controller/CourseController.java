package com.nest.courseapp_backend.controller;

import com.nest.courseapp_backend.dao.CourseDao;
import com.nest.courseapp_backend.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> AddCourse(@RequestBody Course c){
        System.out.println(c.getCourseTitle().toString());
        dao.save(c);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");

        return map;
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Course> view(){
        return (List<Course>) dao.findAll();
    }
    @PostMapping(path = "/search",produces = "application/json",consumes = "application/json")
    public List<Course> Search(@RequestBody Course c){
        String courseTitle = c.getCourseTitle();
        System.out.println(courseTitle);
        return(List<Course>) dao.Search(c.getCourseTitle());

    }


}
