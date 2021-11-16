package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Supervisor;
import com.mec.libapi.domain.pojo.userModule.Supervisor;
import com.mec.libapi.infrastructure.converter.userModule.SupervisorConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.SupervisorFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.SupervisorRepository;
import com.mec.libapi.infrastructure.entity.userModule.SupervisorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class SupervisorFacadeImpl extends AbstractFacadeImpl implements SupervisorFacade {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Qualifier("SupervisorInfConverter")
    @Autowired
    private SupervisorConverter converter;

    @Override
    public Supervisor save(Supervisor supervisor) {
        SupervisorEntity supervisorEntity = converter.to(supervisor);
        SupervisorEntity savedNSupervisor = supervisorRepository.save(supervisorEntity);
        return converter.toPOJO(savedNSupervisor);
    }

    @Override
    public Supervisor findById(Long id) {
        Optional<SupervisorEntity> supervisorEntity = supervisorRepository.findById(id);
        if (supervisorEntity.isPresent()) {
            Supervisor supervisor = converter.toPOJO(supervisorEntity.get());
            return supervisor;
        }
        return null;
    }

    @Override
    public Stream<Supervisor> findAll() {
        List<SupervisorEntity> supervisorEntities = supervisorRepository.findAll();
        List<Supervisor> supervisors = new ArrayList<>();
        supervisorEntities.forEach(supervisorEntity -> {
            supervisors.add(converter.toPOJO(supervisorEntity));
        });
        return supervisors.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<SupervisorEntity> supervisorEntity = supervisorRepository.findById(id);
        supervisorRepository.delete(supervisorEntity.get());
    }
}
