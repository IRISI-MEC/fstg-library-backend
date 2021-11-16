package com.mec.libapi.domain.pojo.bookModule;

import java.util.List;

public class NCase {

    private Long id;
    private String code;
    private List<Instance> instances;

    public NCase() {
    }

    public NCase(Long id, String code, List<Instance> instances) {
        this.id = id;
        this.code = code;
        this.instances = instances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }
}
