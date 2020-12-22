package com.esd.erp.placement.controller;


import com.esd.erp.placement.bean.StudentCourses;
import com.esd.erp.placement.services.StudentCoursesService;
import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("studentcourses")
public class StudentCoursesController {
    StudentCoursesService scService = new StudentCoursesService();

    @POST
    @Path("/addCourses")
    public Response addStudentCourses() throws URISyntaxException{
        AddingData addingData = new AddingData();
        addingData.addStudentCoursesTaken();
        System.out.println("Inside adding of student courses Controller");
        return Response.ok().build();
    }
}
