package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Student;
import com.mec.libapi.infrastructure.converter.userModule.StudentConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.StudentFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.StudentRepository;
import com.mec.libapi.infrastructure.entity.userModule.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentFacadeImpl extends AbstractFacadeImpl implements StudentFacade {

    @Autowired
    private StudentRepository studentRepository;

    @Qualifier("StudentInfConverter")
    @Autowired
    private StudentConverter converter;

    @Override
    public Student save(Student student) {
        StudentEntity studentEntity = converter.to(student);
        StudentEntity savedNStudent = studentRepository.save(studentEntity);
        return converter.toPOJO(savedNStudent);
    }

    @Override
    public Student findById(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            Student student = converter.toPOJO(studentEntity.get());
            return student;
        }
        return null;
    }

    @Override
    public Stream<Student> findAll() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<Student> students = new ArrayList<>();
        studentEntities.forEach(studentEntity -> {
            students.add(converter.toPOJO(studentEntity));
        });
        return students.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        studentRepository.delete(studentEntity.get());
    }
}
