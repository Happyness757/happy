package com.happy.CRUD_HAPPY.repository;

import com.happy.CRUD_HAPPY.entity.MilestoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<MilestoneEntity, Long> {
    //all crud methods for database
}
