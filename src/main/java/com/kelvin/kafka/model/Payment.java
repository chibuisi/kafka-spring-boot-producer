package com.kelvin.kafka.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Payment {
    private Integer id;
    private Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String username;
    private String email;

    public Payment(Integer id, Double amount, LocalDate date, String username, String email) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
