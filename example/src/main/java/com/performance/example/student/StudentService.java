package com.performance.example.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto studentDto){
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    // findAllStudents
    public List<StudentResponseDto> findAllStudent(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    public StudentResponseDto findStudentById(Integer id){
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByName(String name){
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    public void delete(Integer id){
         repository.deleteById(id);
    }
}
