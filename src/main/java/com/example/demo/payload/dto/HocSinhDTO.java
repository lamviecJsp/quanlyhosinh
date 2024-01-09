package com.example.demo.payload.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HocSinhDTO {
    private int lopId;
    private String hoten;
    private String quequan;
    private LocalDate namsinh;
}
