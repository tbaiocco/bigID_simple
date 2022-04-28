package com.bigid.challenge.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultRepositoryInMemory {

    private final List<ResultResource> resultResourceList;

    public ResultRepositoryInMemory() {
        this(new ArrayList<>());
    }

    public ResultRepositoryInMemory(List<ResultResource> resultResourceList) {
        this.resultResourceList = resultResourceList;
    }

    public void addResult(ResultResource result) {
        if (Objects.nonNull(result) && Objects.nonNull(result.getOccurrences()) && !result.getOccurrences().isEmpty()) {
            this.resultResourceList.add(result);
        }
    }

    public List<ResultResource> getAll() {
        return this.resultResourceList;
    }

}
