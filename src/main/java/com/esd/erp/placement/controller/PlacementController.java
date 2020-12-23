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
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@Path("placement")           //This is just a path for which will get appended in URI
public class PlacementController
{
    static PlacementService placementService = new PlacementService();
    private static Integer idVal;

    public static void main(String args[]) throws URISyntaxException
    {
       // String Id="{\"org_id\":[\"1\"]}";
       // sendOrgID(Id);
        getAppliedStudents();
    }




    @POST
    @Path("/addCompanies")
    public Response addCompany() throws URISyntaxException
    {
        AddingData addingData = new AddingData();
        //addingData.addPlacementData();
        System.out.println("Inside Add companies");
        return Response.ok().build();
    }

    @POST
    @Path("/sendSelectedOrgID")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendOrgID(String Id)  throws URISyntaxException
    {
        System.out.println("Inside Org ID receiver fun:"+Id);
        System.out.println("Sending OK to frontend from ID receiver");

        String numberOnly= Id.replaceAll("[^0-9]", "");
        idVal=Integer.parseInt(numberOnly);

        System.out.println("Org_id (After Parsing): "+ idVal);
        //placementService.getCompanyId(idVal);

        return Response.ok().build();
    }



    @GET
    @Path("/displayorg")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganizations() {
        List<Placement> orgs = placementService.getOrganizations();

        return Response.ok().entity(orgs).build();
    }


    @GET
    @Path("/appliedstudents")
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getAppliedStudents()
    {
        System.out.println("Inside getAppstud data of controller");
        Integer temp;
        List<Object[]> appliedStud = placementService.getAppliedStudentsData();
        List<Object[]> appliedStudCompany=null;
        for(int i=0;i<appliedStud.size();i++)
        {
            System.out.println("Element "+ i + " is" + appliedStud.get(i)[6]);
            temp= (Integer)appliedStud.get(i)[6];
            if(temp==idVal)
            {
                System.out.println("Inside comparision of placement ids");
                appliedStudCompany.add(appliedStud.get(i));
            }

        }


        return Response.ok().entity(appliedStudCompany).build();
    }
}
