package com.josemeurer.payroll.dtos;

public class PaymentDto {

    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    public PaymentDto() {
    }

    public PaymentDto(String name, Double dailyIncome, Integer days, Double total) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
