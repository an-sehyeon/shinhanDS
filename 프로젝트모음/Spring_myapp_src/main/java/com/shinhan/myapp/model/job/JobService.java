package com.shinhan.myapp.model.job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	@Autowired
	JobDAO jobDAO;
	
    public List<JobDTO> getAllJobs() {
    	  List<JobDTO> jobs = new ArrayList<>();
        return jobDAO.getAllJobs();
    }
    
    public boolean addJob(JobDTO job) {
        return false;
    }
    
    public boolean updateJob(JobDTO job) {
        return false;
    }
    
    public boolean deleteJob(String jobId) {
       
        return false;
    }
}
