package com.mec.libapi.domain.process.bookModule.book.instance.delete;

import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.domain.process.core.AbstractProcessImpl;
import com.mec.libapi.domain.process.core.Result;
import com.mec.libapi.infrastructure.dao.facade.bookModule.InstanceFacade;

public class InstanceDeleteProcessImpl extends AbstractProcessImpl<InstanceDeleteInput> implements InstanceDeleteProcess {

    private InstanceFacade instanceFacade;

    public InstanceDeleteProcessImpl(InstanceFacade instanceFacade) {
        this.instanceFacade = instanceFacade;
    }

    @Override
    public void validate(InstanceDeleteInput input, Result result) {
        Instance instance = instanceFacade.findById(input.getId());
        if (instance == null) result.addErrorMessage("Instance not found with id: " + instance.getId());
    }

    @Override
    public void run(InstanceDeleteInput input, Result result) {
        instanceFacade.delete(input.getId());
        result.addInfoMessage("Instance deleted successfully");
    }
}
