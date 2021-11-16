package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Department;
import com.mec.libapi.infrastructure.entity.userModule.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component("DepartmentInfConverter")
public class DepartmentConverter {

    public DepartmentEntity to(Department department) {
        return DepartmentEntity.builder()
                .id(department.getId())
                .label(department.getLabel())
                .description(department.getDescription())
                .build();
    }

    public Department toPOJO(DepartmentEntity departmentEntity) {
        Department department = new Department();
        department.setId(departmentEntity.getId());
        department.setLabel(departmentEntity.getLabel());
        department.setDescription(departmentEntity.getDescription());
        return department;
    }
}
