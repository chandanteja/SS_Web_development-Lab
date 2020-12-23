package com.esd.erp.placement.bean;

import javax.persistence.*;

@Entity
@Table(name= "Placement_Student")
public class PlacementStudent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PS_id;



    @ManyToOne
    @JoinColumn(name="Placement_id")
    private Placement Placement_id;

    @ManyToOne
    @JoinColumn(name="Stud_id")
    private Students Stud_id;

    @Column(nullable = false)
    private String Status;


    @Column(name="date")
    private String Date;

    public PlacementStudent(Integer PS_id, Placement placement_id, Students stud_id, String status, String date) {
        this.PS_id = PS_id;
        Placement_id = placement_id;
        Stud_id = stud_id;
        Status = status;
        Date = date;
    }

    public PlacementStudent() {
    }

    public Integer getPS_id() {
        return PS_id;
    }

    public void setPS_id(Integer PS_id) {
        this.PS_id = PS_id;
    }

    public Placement getPlacement_id() {
        return Placement_id;
    }

    public void setPlacement_id(Placement placement_id) {
        Placement_id = placement_id;
    }

    public Students getStud_id() {
        return Stud_id;
    }

    public void setStud_id(Students stud_id) {
        Stud_id = stud_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
