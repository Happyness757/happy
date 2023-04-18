package com.happy.CRUD_HAPPY;

import com.happy.CRUD_HAPPY.entity.MilestoneEntity;
import com.happy.CRUD_HAPPY.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudHappyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudHappyApplication.class, args);
	}

	@Autowired
	private MilestoneRepository milestoneRepository;
	@Override
	public void run(String... args) throws Exception {
		MilestoneEntity milestoneEntity = new MilestoneEntity();
		milestoneEntity.setMilestoneName("Requirement gathering");
		milestoneEntity.setMilestoneDescription("1.Functional and Non-Functional requirements" +
				"Examples of Non-Functional are storage, security, performance");
		milestoneEntity.setStartDate("13/04/2023");
		milestoneEntity.setEndDate("10/10/2023");
		milestoneEntity.setStatus("Progress");
		milestoneRepository.save(milestoneEntity);

	}
}
