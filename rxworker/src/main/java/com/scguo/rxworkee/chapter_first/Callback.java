package com.scguo.rxworkee.chapter_first;

import java.util.function.Consumer;

public class Callback {
    private Consumer<String> mOnResponse = (String x) -> {
    };
    private Consumer<Exception> mOnFailure = (Exception x) -> {
    };

    Callback onResponse(Consumer<String> consumer) {
        this.mOnResponse = consumer;
        return this;
    }

    Callback onFailure(Consumer<Exception> consumer) {
        this.mOnFailure = consumer;
        return this;
    }

    public Consumer<String> getOnResponse() {
        return mOnResponse;
    }

    public Consumer<Exception> getOnFailure() {
        return mOnFailure;
    }
}
