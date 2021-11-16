package com.mec.libapi.infrastructure.dao.core;

import com.mec.libapi.infrastructure.dao.core.messaging.LocalMessageReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AbstractFacadeImpl {
    @Autowired
    private LocalMessageReader localMessageReader;

    @Autowired
    private ApplicationContext context;

    public String getMessage(String code) {
        String message = localMessageReader.getMessage(code);
        return message;
    }

    public <T> T getProcess(Class<T> className) {
        return context.getBean(className);
    }

    public String init(Class className) {
        return "SELECT item FROM " + className.getSimpleName() + " item WHERE 1=1";
    }

    public String addCriteria(String key, Object valueMin, Object valueMax) {
        String query = addCriteria(key, valueMin, "<=");
        query += addCriteria(key, valueMax, ">=");
        return query;
    }

    public String addCriteria(String key, Object value, String operator) {
        if (value != null && !value.toString().isEmpty()) {
            if (value instanceof String && operator.equals("LIKE")) {
                return " AND " + key + " " + operator + " '%" + value + "%'";
            }
            return " AND " + key + " " + operator + " '" + value + "'";
        }
        return "";
    }
}
