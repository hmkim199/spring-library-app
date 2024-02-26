package com.group.libraryapp.fruit.dto;

public class CountFruitByNameResponse {
    private long count;

    public CountFruitByNameResponse(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
