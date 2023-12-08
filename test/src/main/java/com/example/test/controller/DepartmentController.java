package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entity.DepartmentEntity;
import com.example.test.repository.DepartmentRepository;
import com.example.test.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	DepartmentService departmentService;

	@GetMapping(value = "/get/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DepartmentEntity getDepartment(@PathVariable int id) {
		DepartmentEntity departmentEntity = departmentRepository.findById(id);
		return departmentEntity;
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity depaEntity) {
		return departmentRepository.save(depaEntity);
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DepartmentEntity> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@PutMapping(value = "/update/id/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateDepartment(@PathVariable int id, @RequestBody DepartmentEntity depaEntity) {
		departmentService.updateDepartment(id, depaEntity);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteDepartment(@PathVariable int id) {
		departmentService.deleteDepartment(id);

	}

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {
		return "gouse basha";
	}
}
