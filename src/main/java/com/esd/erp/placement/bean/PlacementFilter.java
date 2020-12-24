package com.esd.erp.placement.bean;


import javax.persistence.*;

@Entity
@Table(name = "Placement_Filter")
public class PlacementFilter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PF_id;

    @ManyToOne
    @JoinColumn(name="Placement_id")
    private Placement Placement_id;

    @Column(nullable = false) //columnDefinition="default 'TSCD'")
    private String Specialization;

    @Column(nullable = false)
    private String Domain;


    public PlacementFilter(Integer PF_id, Placement placement_id, String specialization, String domain) {
        this.PF_id = PF_id;
        Placement_id = placement_id;
        Specialization = specialization;
        Domain = domain;
    }

    public PlacementFilter() {
    }

    public Integer getPF_id() {
        return PF_id;
    }

    public void setPF_id(Integer PF_id) {
        this.PF_id = PF_id;
    }

    public Placement getPlacement_id() {
        return Placement_id;
    }

    public void setPlacement_id(Placement placement_id) {
        Placement_id = placement_id;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }
}
