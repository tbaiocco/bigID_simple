package com.bigid.challenge.repository;

import java.util.List;

public class ResultResource {

    private final String name;
    private final List<ResultNameOccurrence> occurrences;

    public ResultResource(Builder builder) {
        this.name = builder.name;
        this.occurrences = builder.occurrences;
    }

    public String getName() {
        return name;
    }

    public List<ResultNameOccurrence> getOccurrences() {
        return occurrences;
    }


    @Override
    public String toString() {
        return name.concat(" --> ").concat(occurrences.toString());
    }

    public static class Builder {

        private final String name;
        private List<ResultNameOccurrence> occurrences;

        public Builder(String name) {
            this.name = name;
        }

        public Builder occurrences(List<ResultNameOccurrence> occurrences) {
            this.occurrences = occurrences;
            return this;
        }

        public ResultResource build() {
            return new ResultResource(this);
        }
    }
}
