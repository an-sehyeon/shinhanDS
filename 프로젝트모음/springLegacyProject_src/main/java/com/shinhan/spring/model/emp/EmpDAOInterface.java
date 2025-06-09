package com.shinhan.spring.model.emp;

import java.util.List;


public interface EmpDAOInterface {

	// Stored Procedure�� �����ϱ� (������ȣ�� �޾Ƽ� �̸��ϰ� �޿��� return)
	public EmpDTO execure_sp(int empid);
	// ������Ʈ
	public int empUpdate(EmpDTO emp);
	// �Է�
	public int empInsert(EmpDTO emp);
	// ����
	public int empDeleteById(int empid) ;
	// deptArr(���� ��ȸ),job, salary, hire_date�� ��ȸ
	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate);

	public List<EmpDTO> selectByCondition(Integer[] arr, String jobid, int salary, String hdate, String date_check);
	
	// job, dept���� ������ȸ
	public List<EmpDTO> selectByJobAndDept(String job, int dept);
	// job���� ������ȸ
	public List<EmpDTO> selectByJob(String job);	
	// �μ��� ������ȸ
	public List<EmpDTO> selectByDept(int deptid);
	// ������ȣ�� ������ ������ �󼼺���
	public EmpDTO selectById(int empid);
	// ��� ���� ��ȸ
	public List<EmpDTO> selectAll(); 
}
