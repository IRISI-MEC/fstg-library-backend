package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Professor;
import com.mec.libapi.infrastructure.converter.userModule.ProfessorConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.ProfessorFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.ProfessorRepository;
import com.mec.libapi.infrastructure.entity.userModule.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProfessorFacadeImpl extends AbstractFacadeImpl implements ProfessorFacade {

    @Autowired
    private ProfessorRepository professorRepository;

    @Qualifier("ProfessorInfConverter")
    @Autowired
    private ProfessorConverter converter;

    @Override
    public Professor save(Professor professor) {
        ProfessorEntity professorEntity = converter.to(professor);
        ProfessorEntity savedNProfessor = professorRepository.save(professorEntity);
        return converter.toPOJO(savedNProfessor);
    }

    @Override
    public Professor findById(Long id) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(id);
        if (professorEntity.isPresent()) {
            Professor professor = converter.toPOJO(professorEntity.get());
            return professor;
        }
        return null;
    }

    @Override
    public Stream<Professor> findAll() {
        List<ProfessorEntity> professorEntities = professorRepository.findAll();
        List<Professor> professores = new ArrayList<>();
        professorEntities.forEach(professorEntity -> {
            professores.add(converter.toPOJO(professorEntity));
        });
        return professores.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(id);
        professorRepository.delete(professorEntity.get());
    }
}
