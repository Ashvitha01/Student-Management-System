package in.ashvi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ashvi.entity.Student;
import in.ashvi.repository.IStudentRepository;

@Component // used to create the object for this class
public class StudentServiceImpl  implements IStudentService{
	
	@Autowired  //dependency injection
	IStudentRepository istudentrepository;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		Student saved = istudentrepository.save(student);
		System.out.println("Entered into servicelayer");
		return saved;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> getalldata = istudentrepository.findAll();
		System.out.println("entered into getall in servicelayer");
		return getalldata;
	}

	@Override
	public Student getStudentByid(int id) {
		// TODO Auto-generated method stub
		
		Optional<Student> findbyid = istudentrepository.findById(id);
		return findbyid.get();
	}

	@Override
	public Student updateStudentByid(Student student,int id) {
		// TODO Auto-generated method stub
		Student findupdate = istudentrepository.findById(id).get();
		
		if(findupdate!=null) {
			findupdate.setId(id);
			findupdate.setName(student.getName());
			findupdate.setAddress(student.getAddress());
			findupdate.setMark(student.getMark());
			Student update = istudentrepository.save(findupdate);
			return update;
		}
		
		return null;
	}

	@Override
	public String deleteStudentByid(int id) {
		// TODO Auto-generated method stub
		istudentrepository.deleteById(id);
		return "Successfully deleted";
	}

}
