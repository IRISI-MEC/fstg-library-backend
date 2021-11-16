package com.mec.libapi.domain.process.core;

public abstract class AbstractProcessImpl<T extends AbstractProcessInput> {


    public Result execute(T input) {
        Result result = new Result();
        if (validateProcess(input, result)) {
            run(input, result);
        }
        return result;
    }

    public boolean validateProcess(T input, Result result) {
        validate(input, result);
        return result.hasError();
    }


    public abstract void validate(T input, Result result);

    public abstract void run(T input, Result result);

}
