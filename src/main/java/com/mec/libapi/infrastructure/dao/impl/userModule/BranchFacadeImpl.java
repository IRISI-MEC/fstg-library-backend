package com.mec.libapi.infrastructure.dao.impl.userModule;

import com.mec.libapi.domain.pojo.userModule.Branch;
import com.mec.libapi.infrastructure.converter.userModule.BranchConverter;
import com.mec.libapi.infrastructure.dao.core.AbstractFacadeImpl;
import com.mec.libapi.infrastructure.dao.facade.userModule.BranchFacade;
import com.mec.libapi.infrastructure.dao.repository.userModule.BranchRepository;
import com.mec.libapi.infrastructure.entity.userModule.BranchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BranchFacadeImpl extends AbstractFacadeImpl implements BranchFacade {

    @Autowired
    private BranchRepository branchRepository;

    @Qualifier("BranchInfConverter")
    @Autowired
    private BranchConverter converter;

    @Override
    public Branch save(Branch branch) {
        BranchEntity branchEntity = converter.to(branch);
        BranchEntity savedNBranch = branchRepository.save(branchEntity);
        return converter.toPOJO(savedNBranch);
    }

    @Override
    public Branch findById(Long id) {
        Optional<BranchEntity> branchEntity = branchRepository.findById(id);
        if (branchEntity.isPresent()) {
            Branch branch = converter.toPOJO(branchEntity.get());
            return branch;
        }
        return null;
    }

    @Override
    public Stream<Branch> findAll() {
        List<BranchEntity> branchEntities = branchRepository.findAll();
        List<Branch> branches = new ArrayList<>();
        branchEntities.forEach(branchEntity -> {
            branches.add(converter.toPOJO(branchEntity));
        });
        return branches.stream();
    }

    @Override
    public void delete(Long id) {
        Optional<BranchEntity> branchEntity = branchRepository.findById(id);
        branchRepository.delete(branchEntity.get());
    }
}
