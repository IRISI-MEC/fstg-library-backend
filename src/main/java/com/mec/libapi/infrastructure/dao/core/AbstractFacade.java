package com.mec.libapi.infrastructure.dao.core;

import java.util.stream.Stream;

public interface AbstractFacade<T, K> {

    String getMessage(String code);

    <T> T getProcess(Class<T> className);

    T save(T t);

    T findById(K id);

    Stream<T> findAll();

    void delete(K id);
}
