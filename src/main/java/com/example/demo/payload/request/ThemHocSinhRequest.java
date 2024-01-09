package com.example.demo.payload.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ThemHocSinhRequest {
    private int lopId;
    private String hoten;
    private String quequan;
    private LocalDate namsinh;
}
