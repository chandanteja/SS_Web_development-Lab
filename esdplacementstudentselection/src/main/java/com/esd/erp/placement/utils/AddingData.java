package com.esd.erp.placement.utils;

import com.esd.erp.placement.bean.*;
import com.esd.erp.placement.services.*;

import javax.validation.constraints.Null;
import java.util.Date;


public class AddingData
{
    public void addEmployeeData()
    {
        EmployeeService empService = new EmployeeService();
        //employee emp = new employee(6, "emp6", "emp7", "emp7@iiitb.org", "HOD", "Maintenance");
        //employeeService.addEmployee(emp);

        Employee emp = new Employee(1, "arun", "raj", "arunraj@iiitb.org", "Outreach");
        empService.addEmployee(emp);
        Employee emp1 = new Employee(2, "das", "gupta", "dasgupta@iiitb.org", "Outreach");
        empService.addEmployee(emp1);
        Employee emp2 = new Employee(3, "arun", "raj", "arunraj_acc@iiitb.org", "Accounts");
        empService.addEmployee(emp2);

        Employee emp3 = new Employee(4, "akshay", "kumar", "akshaykum@iiitb.org", "IT Services");
        empService.addEmployee(emp3);
    }

      public void addPlacementData() {
          PlacementService placementService = new PlacementService();
          Placement p1 = new Placement(1, "Microsoft", "sde", "software development engineer", 10, 3.0);
          placementService.addCompany(p1);
          Placement p2 = new Placement(2, "Cisco", "CSA", "Computer System Analyst", 5, 3.0);
          placementService.addCompany(p2);
          Placement p3 = new Placement(3, "Broadcom", "sde", "software development engineer", 8, null);
          placementService.addCompany(p3);
          Placement p4 = new Placement(4, "Amazon", "Applied scientist", "Research Scientist", 2, 3.0);
          placementService.addCompany(p4);
          Placement p5 = new Placement(5, "Rubrik", "sde", "Cloud Engnieer", 10, null);
          placementService.addCompany(p5);
          Placement p6 = new Placement(6, "AppDynamics", "sde", "Data Quality Engineer", 10, 3.2);
          placementService.addCompany(p6);
      }
    public void addStudentData()
    {
        StudentsService studentsService = new StudentsService();

        Students s1 = new Students(1, "MT2020001", "Clark", "M", "c@iiitb.org", 2.8, 2020, "MTECH2018CSE", "AIML");
        studentsService.addStudent(s1);
        Students s2 = new Students(2, "MT2020002", "Bruce", "W", "b@iiitb.org", 3.2, 2020, "MTECH2018CSE", "TSCD");
        studentsService.addStudent(s2);
        Students s3 = new Students(3, "MT2020003", "Diana", "T", "d@iiitb.org", 3.6, 2020, "MTECH2018CSE", "NC");
        studentsService.addStudent(s3);
        Students s4 = new Students(4, "MT2020004", "Jon", "P", "J@iiitb.org", 2.9, 2020, "MTECH2018CSE", "AIML");
        studentsService.addStudent(s4);
        Students s5 = new Students(5, "MT2020005", "Barry", "R", "br@iiitb.org", 3.4, 2021, "MTECH2019CSE", "TSCD");
        studentsService.addStudent(s5);

        Students s6 = new Students(6, "MT2020006", "Jerry", "T", "Jerry@iiitb.org", 3.2, 2022, "MTECH2020CSE", "TSCD");
        studentsService.addStudent(s6);
    }
    public void addPlacementFilterData()
    {
        PlacementFilterService pfs = new PlacementFilterService();
        Placement p1 = new Placement(1, "Microsoft", "sde", "software development engineer", 10, 3.0);
        PlacementFilter pf = new PlacementFilter(1, p1,"TSCD","MT2020CSE");
        pfs.addPlacementFilterEntry(pf);

        Placement p2 = new Placement(2, "Cisco", "CSA", "Computer System Analyst", 5, 3.0);
        PlacementFilter pf1 = new PlacementFilter(2, p2,"AIML","MT2020CSE");
        pfs.addPlacementFilterEntry(pf);

        Placement p6 = new Placement(6, "AppDynamics", "sde", "Data Quality Engineer", 10, 3.2);
        PlacementFilter pf2 = new PlacementFilter(3, p6,"AIML","MT2020CSE");
        pfs.addPlacementFilterEntry(pf2);

    }

    public void addStudentCoursesTaken()
    {
        StudentCoursesService scs = new StudentCoursesService();

        Students s6 = new Students(6, "MT2020006", "Jerry", "T", "Jerry@iiitb.org", 3.2, 2022, "MTECH2020CSE", "TSCD");
        StudentCourses sc = new StudentCourses(1,"Algorithms",s6,3.2);
        scs.addStudentCourses(sc);

        Students s5 = new Students(5, "MT2020005", "Barry", "R", "br@iiitb.org", 3.4, 2021, "MTECH2019CSE", "TSCD");
        StudentCourses sc1 = new StudentCourses(2,"ML",s5,3.0);
        scs.addStudentCourses(sc1);
    }
/*
        placStudService placStudService = new placStudService();
        //public placement_student(Integer id, placement placement_id, students student_id,  String acceptance, String comments, String date) {
        placement_student ps1 = new placement_student(1, p1, s1 , "ACCEPT", "02-11-20020");
        placStudService.addPlacStud(ps1);
        placement_student ps2 = new placement_student(2, p1, s2 , "REJECT", "03-11-20020");
        placStudService.addPlacStud(ps2);
        placement_student ps3 = new placement_student(3, p1, s3 , "REJECT", "03-11-20020");
        placStudService.addPlacStud(ps3);
        placement_student ps4 = new placement_student(4, p2, s3 , "ACCEPT", "10-11-20020");
        placStudService.addPlacStud(ps4);
        placement_student ps5 = new placement_student(5, p3, s4 , "PENDING", "10-12-20020");
        placStudService.addPlacStud(ps5);
        placement_student ps6 = new placement_student(6, p4, s2 , "ACCEPT", "11-12-20020");
        placStudService.addPlacStud(ps6);
        placement_student ps7 = new placement_student(7, p5, s5 , "REJECT", "11-12-20020");
        placStudService.addPlacStud(ps7);
        placement_student ps8 = new placement_student(8, p6, s5 , "ACCEPT", "12-12-20020");
        placStudService.addPlacStud(ps8);

       */

    }

