package com.bigid.challenge.repository;

public class LineResource {

    private final long lineOffset;
    private final String lineContent;

    public LineResource(Builder builder) {
        this.lineOffset = builder.lineOffset;
        this.lineContent = builder.lineContent;
    }

    public long getLineOffset() {
        return lineOffset;
    }

    public String getLineContent() {
        return lineContent;
    }

    @Override
    public String toString() {
        return "line [".concat(String.valueOf(this.lineOffset))
                .concat(":").concat(String.valueOf(this.lineContent))
                .concat("]");
    }

    public static class Builder {

        private final long lineOffset;
        private final String lineContent;

        public Builder(long lineOffset, String lineContent) {
            this.lineOffset = lineOffset;
            this.lineContent = lineContent;
        }

        public LineResource build() {
            return new LineResource(this);
        }
    }

}
