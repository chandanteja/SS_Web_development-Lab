package com.esd.erp.placement.bean;

import javax.persistence.*;

@Entity
@Table(name= "Placement_Student")
public class Placement_Student
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
    private String Acceptance;


    @Column(name="date")
    private String Date;



}
