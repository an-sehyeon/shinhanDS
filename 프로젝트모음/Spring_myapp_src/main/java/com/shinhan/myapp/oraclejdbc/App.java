package com.shinhan.myapp.oraclejdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shinhan.myapp.model.board.BoardService;
import com.shinhan.myapp.model.dept.DeptDTO;
import com.shinhan.myapp.model.dept.DeptService;
import com.shinhan.myapp.model.emp.EmpService;
import com.shinhan.myapp.model.job.JobService;

public class App {
	static ApplicationContext ctx;
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		f4();
	}
	
	
	private static void f4() {
		ctx = new ClassPathXmlApplicationContext("oraclejdbc.xml");
		JobService jobService = ctx.getBean("jobService",JobService.class);
		jobService.getAllJobs().forEach(job->System.out.println(job));
		
	}
	
	
	private static void f3() {
		ctx = new ClassPathXmlApplicationContext("oraclejdbc.xml");
		BoardService boardService = ctx.getBean("boardService",BoardService.class);
		boardService.selectAll().forEach(board->System.out.println(board));
		
		
	}


	private static void f2() {
		ctx = new ClassPathXmlApplicationContext("oraclejdbc.xml");
		EmpService empService = ctx.getBean("empService",EmpService.class);
		empService.selectAll().forEach(emp->System.out.println(emp));
		
	}


	public static void  f1() {
		ctx = new ClassPathXmlApplicationContext("oraclejdbc.xml");
		DeptService deptService = ctx.getBean("deptService",DeptService.class);
		
		List<DeptDTO> deptlist = deptService.selectAll();
		deptlist.stream().forEach(dept->System.out.println(dept));
		
	}

}
