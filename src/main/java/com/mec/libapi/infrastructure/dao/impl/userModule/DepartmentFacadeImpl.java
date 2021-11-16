package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Department;
import com.mec.libapi.infrastructure.converter.userModule.DepartmentConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.DepartmentFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.DepartmentRepository;
import com.mec.libapi.infrastructure.entity.userModule.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DepartmentFacadeImpl extends AbstractFacadeImpl implements DepartmentFacade {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Qualifier("DepartmentInfConverter")
    @Autowired
    private DepartmentConverter converter;

    @Override
    public Department save(Department department) {
        DepartmentEntity departmentEntity = converter.to(department);
        DepartmentEntity savedNDepartment = departmentRepository.save(departmentEntity);
        return converter.toPOJO(savedNDepartment);
    }

    @Override
    public Department findById(Long id) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        if (departmentEntity.isPresent()) {
            Department department = converter.toPOJO(departmentEntity.get());
            return department;
        }
        return null;
    }

    @Override
    public Stream<Department> findAll() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        List<Department> departmentes = new ArrayList<>();
        departmentEntities.forEach(departmentEntity -> {
            departmentes.add(converter.toPOJO(departmentEntity));
        });
        return departmentes.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(id);
        departmentRepository.delete(departmentEntity.get());
    }
}
