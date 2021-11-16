package com.mec.libapi.infrastructure.dao.facade;

import java.util.Optional;
import java.util.stream.Stream;

public interface AbstractFacade<T, ID> {

    String getMessage(String code);

    <T> T getProcess(Class<T> className);

    T save(T t);

    T findById(ID id);

    Stream<T> findAll();

    void delete(ID id);
}
