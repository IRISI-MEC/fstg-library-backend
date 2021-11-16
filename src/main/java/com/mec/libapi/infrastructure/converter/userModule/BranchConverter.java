package com.mec.libapi.infrastructure.converter.userModule;

import com.mec.libapi.domain.pojo.userModule.Branch;
import com.mec.libapi.infrastructure.entity.userModule.BranchEntity;
import org.springframework.stereotype.Component;

@Component("BranchInfConverter")
public class BranchConverter {

    public BranchEntity to(Branch branch) {
        return BranchEntity.builder()
                .id(branch.getId())
                .label(branch.getLabel())
                .description(branch.getDescription())
                .build();
    }

    public Branch toPOJO(BranchEntity branchEntity) {
        Branch branch = new Branch();
        branch.setId(branchEntity.getId());
        branch.setLabel(branchEntity.getLabel());
        branch.setDescription(branchEntity.getDescription());
        return branch;
    }
}
