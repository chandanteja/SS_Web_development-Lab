package com.esd.erp.placement.controller;


import com.esd.erp.placement.bean.Placement;
import com.esd.erp.placement.services.PlacementService;
import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("placement")           //This is just a path for which will get appended in URI
public class PlacementController
{
    PlacementService placementService = new PlacementService();

    @POST
    @Path("/addCompanies")
    public Response addCompany() throws URISyntaxException
    {
        AddingData addingData = new AddingData();
        //addingData.addPlacementData();
        System.out.println("Inside Add companies");
        return Response.ok().build();
    }

  /*  @POST
    @Path("/sendSelectedOrgID")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendOrgID()
    {

    }
    */


    @GET
    @Path("/displayorg")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations() {
        List<Placement> orgs = placementService.getOrganizations();
       /* for( Placement i : orgs ) {
            System.out.println(i);
        }
    System.out.println("Inside printing companies");*/

        return Response.ok().entity(orgs).build();
    }



}
