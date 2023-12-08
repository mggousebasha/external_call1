package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.entity.DepartmentEntity;
import com.example.test.repository.DepartmentRepository;



@Service
public class DepartmentService {

	@Autowired
	public DepartmentRepository departmentRepository;
	
	public List<DepartmentEntity> getAllDepartments()
	{
		List<DepartmentEntity> departments = new ArrayList<DepartmentEntity>();
		departmentRepository.findAll().forEach(departments::add);
		return departments;
	}

	public void updateDepartment(int id, DepartmentEntity depaEntity) {
		departmentRepository.save(depaEntity);
	}

	public void deleteDepartment(int id) {
		departmentRepository.delete(findOneProduct(id));
	}

	private DepartmentEntity findOneProduct(int id) {
		DepartmentEntity dept = departmentRepository.findById(id);
		return dept;
	}
}
