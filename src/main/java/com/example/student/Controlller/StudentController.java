package com.example.student.Controlller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Model.Student;


@RestController
@RequestMapping("/student")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
public class StudentController {
	/*store students
	add new student
	update the student
	delete the student
	get a student
	get students */
	
	/*List<Student>students=new ArrayList<Student>();
	public void add(){
		Student sivaja=new Student("2016-ICT-18","Sivaja Sri",24,"IT",3.0);
		Student sharmi=new Student("2016-ICT-40","Sharmi",24,"IT",3.0);
		Student gopi=new Student("2016-ICT-01","gopi",25,"IT",3.0);
		students.add(sivaja);
		students.add(sharmi);
		students.add(gopi);
		
	} */
	/*@GetMapping
	public List<Student>getAll(){
		add();
		return students;
	} */
	
/*	@GetMapping("/{id}")
	public Student get(@PathVariable("id") String id) {
		
		for(Student student:students) {
			if(student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	} */
	Map<String, Student>students=new HashMap<String, Student>();
	public void add(){
		Student sivaja=new Student("2016-ICT-18","Sivaja Sri",24,"IT",3.0);
		Student athmi=new Student("2016-ICT-40","Athmi",24,"IT",3.0);
		Student ram=new Student("2016-ICT-01","ram",25,"IT",3.0);
		students.put(sivaja.getId(),sivaja);
		students.put(athmi.getId(),athmi);
		students.put(ram.getId(),ram);
	
} 
	@GetMapping()
	public Collection<Student> getAll(){
		add();
		return students.values();
	}
	@GetMapping("/{id}")
	public Student get(@PathVariable("id") String id) {
		//add();
		return students.get(id);
		
	}
	//@PostMapping(consumes="application/json")
	@PostMapping
	public void add(@RequestBody Student student) {
		students.put(student.getId(), student);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		students.remove(id);
	}
	
	@PutMapping
	public void update(@PathVariable("id") String id,@RequestBody Student student) {
		students.put(id,student);
	}
	
}
