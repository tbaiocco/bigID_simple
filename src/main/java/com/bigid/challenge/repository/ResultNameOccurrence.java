package com.bigid.challenge.repository;

public class ResultNameOccurrence {

    private final long lineOffset;
    private final long charOffset;

    public ResultNameOccurrence(Builder builder) {
        this.lineOffset = builder.lineOffset;
        this.charOffset = builder.charOffset;
    }

    @Override
    public String toString() {
        return "[lineOffset=".concat(String.valueOf(this.lineOffset))
                .concat(", charOffset=").concat(String.valueOf(this.charOffset))
                .concat("]");
    }

    public static class Builder {

        private final long lineOffset;
        private final long charOffset;

        public Builder(long lineOffset, long charOffset) {
            this.lineOffset = lineOffset;
            this.charOffset = charOffset;
        }

        public ResultNameOccurrence build() {
            return new ResultNameOccurrence(this);
        }
    }

}
