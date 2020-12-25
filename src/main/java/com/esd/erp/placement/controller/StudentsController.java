package com.esd.erp.placement.controller;

import com.esd.erp.placement.DAO.PlacementDAO;
import com.esd.erp.placement.bean.FilterValues;
import com.esd.erp.placement.services.PlacementService;
import com.esd.erp.placement.services.StudentsService;
import com.esd.erp.placement.utils.AddingData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class StudentsController {

    StudentsService studentsService = new StudentsService();
    public  Integer pla;
    public  String roll;
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
        domain.add("MTECH2018CSE");
        domain.add("MTECH2020CSE");
        domain.add("IMT2018ECE");
        domain.add("IMT2017CSE");
        domain.add("MTECH2019CSE");
        return Response.ok().entity(domain).build();
    }

    @GET
    @Path("/specialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisation() {
        List<String> spsl = new ArrayList<>();
        spsl.add("Show All");
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

    @POST
    @Path("/updatePlacementStat")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendOrgID(String Id)  throws URISyntaxException
    {
        System.out.println("Inside stat receiver fun:"+Id);
        System.out.println("Sending OK to frontend from ID receiver");

        String[] str1 = Id.split(":");
        String[] arrOfStr = str1[1].split("\\s+");
        //System.out.println("hey");
        //System.out.println(arrOfStr[1]);
        //System.out.println(arrOfStr[0]);
        roll=arrOfStr[0].substring(1);//final roll number
        //System.out.println(roll);
        arrOfStr[1] = arrOfStr[1].replaceAll(".$", "");
        arrOfStr[1] = arrOfStr[1].replaceAll(".$", "");
        //System.out.println(arrOfStr[1]);

        pla=Integer.parseInt(arrOfStr[1]);//final placement_id status number

        //System.out.println(pla);
        //System.out.println(roll);
        //System.out.println("How");


        studentsService.updatePlacementId(roll,pla);

        return Response.ok().build();
    }

    @POST
    @Path("/Filter")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendFilterData(FilterValues filterval)  throws URISyntaxException
    {
        PlacementController pc= new PlacementController();
        int orgID=pc.getOrgID();
        String splVal=filterval.getSplVal();
        String domVal=filterval.getDomVal();
        System.out.println("Filter spl values front endare: "+splVal);
        System.out.println("Filter dom values front endare: "+domVal);

        PlacementService placementService = new PlacementService();

        List<Object[]> appliedStudList = placementService.getAppliedStudentsData();
        List<Object[]> appliedStudFilter= new ArrayList<>();

        String tempSplVal,tempDomVal;
        Integer tempOrgID;

        for(int i=0;i<appliedStudList.size();i++) {
            System.out.println("SplVal " + i + " is " + appliedStudList.get(i)[4]);
            System.out.println("DomVal " + i + " is " + appliedStudList.get(i)[6]);
            //tempSplVal = appliedStudList.get(i)[4].toString();
            //tempDomVal = appliedStudList.get(i)[6].toString();
            tempSplVal= (String)(appliedStudList.get(i)[4]);
            tempDomVal= (String)(appliedStudList.get(i)[6]);
            tempOrgID =(Integer) appliedStudList.get(i)[7];
            System.out.println("SplVal " + i + " is stirng " + tempSplVal);
            System.out.println("DomVal " + i + " is string" + tempDomVal);


            //System.out.println("type is "+ appliedStud.get(i)[6].getClass() );

            if ( splVal.equals("")==false && domVal.equals("")==false  && orgID == tempOrgID) {

                if (splVal.equalsIgnoreCase(tempSplVal) && domVal.equalsIgnoreCase(tempDomVal)) {
                    System.out.println("Inside comparison of both filter values");
                    appliedStudFilter.add(appliedStudList.get(i));
                }

            } else {
                if (splVal.equals("")==false && orgID == tempOrgID) {
                    if (splVal.equalsIgnoreCase(tempSplVal)) {
                        System.out.println("Inside comparison of splval filter values");
                        appliedStudFilter.add(appliedStudList.get(i));
                    }
                } else if (domVal.equals("")==false && orgID == tempOrgID) {
                    System.out.println("Inside comparison of domval filter values");
                    appliedStudFilter.add(appliedStudList.get(i));
                }
            }

        }
        return Response.ok().entity(appliedStudFilter).build();


        }

}
