package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "banglop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lopid")
    private int id;
    @Column(name = "tenlop")
    private String tenlop;
    @Column(name = "siso")
    private int siso;
    @OneToMany(mappedBy = "lop")
    @JsonManagedReference
    private Set<HocSinh> hocSinhs;
}
