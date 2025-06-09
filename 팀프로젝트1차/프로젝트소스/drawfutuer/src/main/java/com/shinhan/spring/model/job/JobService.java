package com.shinhan.spring.model.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
		@Autowired
		JobDAO jobDAO;
		
	 public List<JobDTO> getAllJobs() {
		 
		 List<JobDTO> joblist = jobDAO.getAllJobs();
		 return joblist;
	 }
}
