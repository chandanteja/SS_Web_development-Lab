package com.esd.erp.placement.bean;

import javax.persistence.*;

@Entity
@Table(name = "Placement")
public class Placement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PlacId;

    @Column(nullable = false)
    private String Org_name;

    @Column(nullable = false)
    private String Profile;


    private String description;

    private Integer Intake;

    @Column(nullable = false, columnDefinition="Decimal(2,1) default '0.0'")
    private Double Min_cgpa;    //to check eligibility for placements

// If we want to have a specialization for particular offer then we need to add one more field with specialization


    public Placement(Integer placement_id, String org_name, String profile, String description, Integer intake, Double min_cgpa)
    {
        PlacId = placement_id;
        Org_name = org_name;
        Profile = profile;
        this.description = description;
        Intake = intake;
        this.Min_cgpa = min_cgpa;
    }

    public Placement()
    {
    }

    public Integer getPlacement_id() {
        return PlacId;
    }

    public void setPlacement_id(Integer placement_id) {
        PlacId = placement_id;
    }

    public String getOrg_name() {
        return Org_name;
    }

    public void setOrg_name(String org_name) {
        Org_name = org_name;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIntake() {
        return Intake;
    }

    public void setIntake(Integer intake) {
        Intake = intake;
    }

    public Double getMin_cgpa() {
        return Min_cgpa;
    }

    public void setMin_cgpa(Double min_cgpa) {
        this.Min_cgpa = min_cgpa;
    }

}
