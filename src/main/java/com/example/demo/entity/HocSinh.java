package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "banghocsinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocsinhid")
    private int id;
    @ManyToOne
    @JoinColumn(name = "lopid", insertable = false, updatable = false)
    @JsonBackReference
    private Lop lop;
    @Column(name = "lopid")
    private int lopId;
    @Column(name = "hoten")
    private String hoten;
    @Column(name = "quequan")
    private String quequan;
    @Column(name = "namsinh")
    private LocalDate namsinh;
}
