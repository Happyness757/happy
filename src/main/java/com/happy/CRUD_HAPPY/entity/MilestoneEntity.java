package com.happy.CRUD_HAPPY.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "milestone_info")
public class MilestoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "milestoneName")
    String milestoneName;
    @Column(name = "milestoneDescription")
    String milestoneDescription;
    @Column(name = "startDate")
    String startDate;
    @Column(name = "endDate")
    String endDate;
    @Column(name = "status")
    String status;
}
