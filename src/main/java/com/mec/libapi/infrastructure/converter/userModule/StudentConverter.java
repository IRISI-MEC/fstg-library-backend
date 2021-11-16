package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Student;
import com.mec.libapi.infrastructure.entity.userModule.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("StudentInfConverter")
public class StudentConverter {

    @Qualifier("BranchInfConverter")
    @Autowired
    private BranchConverter branchConverter;

    public StudentEntity to(Student student) {
        return (StudentEntity) StudentEntity.builder()
                .CNE(student.getCNE())
                .branch(branchConverter.to(student.getBranch()))
                .id(student.getId())
                .username(student.getUsername())
                .firstName(student.getFirstName())
                .secondName(student.getSecondName())
                .email(student.getEmail())
                .password(student.getPassword())
                .overDue(student.getOverDue())
                .build();
    }

    public Student toPOJO(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setUsername(studentEntity.getUsername());
        student.setFirstName(studentEntity.getFirstName());
        student.setSecondName(studentEntity.getSecondName());
        student.setEmail(studentEntity.getEmail());
        student.setPassword(studentEntity.getPassword());
        student.setCNE(studentEntity.getCNE());
        // branch
        return student;
    }
}
