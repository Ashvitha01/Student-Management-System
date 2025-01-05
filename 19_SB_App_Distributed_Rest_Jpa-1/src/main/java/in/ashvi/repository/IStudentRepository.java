package in.ashvi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashvi.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
