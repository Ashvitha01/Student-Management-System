package in.ashvi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashvi.entity.Student;
import in.ashvi.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired  // dependency injection
	IStudentService istudentservice;

	@PostMapping("/Create")
	public Student saveStudent(@RequestBody Student student) // @RequestBody is used to receive the json object and convert into java object and stored in student object in Student class(entity)
	{
		Student saveStudent = istudentservice.saveStudent(student);
		
		System.out.println("Entered into the StudentController" + student);
		return saveStudent;
	}
	
	@GetMapping("/findall")
	public List<Student> getAllStudent()//List is used to insert into fetch bulck of data in java 
	
	{
		List<Student> getallStudent = istudentservice.getAllStudent();
		System.out.println("Entered into gettalldata in controller" );
		
		return getallStudent;
		
	}
	
	@GetMapping("/getStudentByid/{id}")
	public Student getStudentByid(@PathVariable("id") int id) {
		Student getstudentByid = istudentservice.getStudentByid(id);
		
		return getstudentByid;
		
	}
	
	@PutMapping("/updateStudentByid/{id}")
	public Student  updateStudentByid(@RequestBody Student student,@PathVariable("id") int id) {
		System.out.println("Entered into updateByid");
		Student updateByid = istudentservice.updateStudentByid(student, id);
		
		return updateByid;
		
	}
	
	@DeleteMapping("/deleteStudentByid/{id}")
	public String deleteStudentByid(@PathVariable("id") int id) {
		String deleteStudentByid = istudentservice.deleteStudentByid(id);
		
		return "studentdeleted";
		
	}
	
}
