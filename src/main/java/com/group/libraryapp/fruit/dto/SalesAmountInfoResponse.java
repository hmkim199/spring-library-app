package com.group.libraryapp.fruit.dto;

public class SalesAmountInfoResponse {
    private long salesAmount;
    private long notSalesAmount;

    public SalesAmountInfoResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
