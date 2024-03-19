package com.performance.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDto dto = new StudentDto(
                "perf",
                "engineer",
                "perf@test.com",
                1
        );

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals(exp.getMessage(), "The student dto is null");
    }

    @Test
    public void shouldMapStudentToStudentResponseDto(){
        Student student = new Student(
                "Performance",
                "Architect",
                "hello@arch.com",
                10);

        StudentResponseDto response = mapper.toStudentResponseDto(student);

        assertEquals(response.firstname(), student.getFirstname());
        assertEquals(response.lastname(), student.getLastname());
        assertEquals(response.email(), student.getEmail());
    }
}