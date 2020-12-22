package com.esd.erp.placement.controller;



import com.esd.erp.placement.bean.PlacementFilter;
import com.esd.erp.placement.services.PlacementFilterService;
import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("placementfilter")
public class PlacementFilterController
{

    PlacementFilterService placementService = new PlacementFilterService();

    @POST
    @Path("/addFilter")
    public Response addPlacementFilter() throws URISyntaxException
    {
        AddingData addingData = new AddingData();
        addingData.addPlacementFilterData();
        System.out.println("Inside placement filter controller");
        return Response.ok().build();
    }


}
