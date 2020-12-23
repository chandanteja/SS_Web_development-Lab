package com.esd.erp.placement.controller;

import com.esd.erp.placement.services.StudentsService;
import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class StudentsController {

    StudentsService studentsService = new StudentsService();

    @GET
    @Path("/year")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYear() {
        List<String> years = new ArrayList<>();
        years.add("2016");
        years.add("2017");
        years.add("2018");
        years.add("2019");
        years.add("2020");
        return Response.ok().entity(years).build();
    }

    @GET
    @Path("/domain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomain() {
        List<String> domain = new ArrayList<>();
        domain.add("MT2019");
        domain.add("MT2020");
        domain.add("IMT2018");
        domain.add("IMT2017");
        domain.add("IMT2016");
        return Response.ok().entity(domain).build();
    }

    @GET
    @Path("/specialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisation() {
        List<String> spsl = new ArrayList<>();
        spsl.add("TSCD");
        spsl.add("AIML");
        spsl.add("NC");
        spsl.add("VLSI");
        return Response.ok().entity(spsl).build();
    }


    @POST
    @Path("/addstudents")
    public Response addStudent() throws URISyntaxException {
        AddingData addingData = new AddingData();
      //  addingData.addStudentData();
        System.out.println("Sending response code OK to frontend");
        return Response.ok().build();
    }

}
