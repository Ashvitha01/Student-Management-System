package in.ashvi.service;

import java.util.List;

import in.ashvi.entity.Student;

public interface IStudentService {

	public Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentByid(int id);
	public Student updateStudentByid(Student student,int id);
	public String deleteStudentByid(int id);
	
}
