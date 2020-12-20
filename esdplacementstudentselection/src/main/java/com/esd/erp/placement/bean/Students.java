package com.esd.erp.placement.bean;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(nullable = false, unique = true)
    private String roll_num;

    @Column(nullable = false)
    private String first_name;
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition="Decimal(2,1) default '0.0'")
    private Double cgpa;    //to check eligibility for placements

    private Integer grad_year;  //to check eligibility for placements

    private String domain;

 //   @OneToOne
 //   @JoinColumn(name = "Placement_Student_ID")
 //   private placementStudent place_stud_id;

    public Students(Integer student_id, String roll_num, String first_name, String last_name, String email, Double cgpa, Integer grad_year, String domain)//, placementStudent place_stud_id)
    {
        this.student_id = student_id;
        this.roll_num = roll_num;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.cgpa = cgpa;
        this.grad_year = grad_year;
        this.domain = domain;
       // this.place_stud_id = place_stud_id;
    }

    public Students()
    {
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getRoll_num() {
        return roll_num;
    }

    public void setRoll_num(String roll_num) {
        this.roll_num = roll_num;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getGrad_year() {
        return grad_year;
    }

    public void setGrad_year(Integer grad_year) {
        this.grad_year = grad_year;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

  /*  public placementStudent getPlace_stud_id() {
        return place_stud_id;
    }

    public void setPlace_stud_id(placementStudent place_stud_id) {
        this.place_stud_id = place_stud_id;
    }
    */

}