package com.esd.erp.placement.controller;

import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("placementstudent")           //This is just a path for which will get appended in URI

public class PlacementStudentController
{
    @POST
    @Path("/addplacstud")
    public Response addPlacStud() throws URISyntaxException
    {
        AddingData addingData = new AddingData();
        //addingData.addPlacementData();
        System.out.println("Inside Add Placstud controller");
        return Response.ok().build();
    }

}

