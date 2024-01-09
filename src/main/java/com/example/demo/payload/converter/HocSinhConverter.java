package com.example.demo.payload.converter;

import com.example.demo.entity.HocSinh;
import com.example.demo.payload.dto.HocSinhDTO;
import com.example.demo.payload.request.SuaHocSinhRequest;
import com.example.demo.payload.request.ThemHocSinhRequest;
import org.springframework.stereotype.Component;

@Component
public class HocSinhConverter {
    public HocSinhDTO entityToDTO(HocSinh hocSinh) {
        HocSinhDTO dto = new HocSinhDTO();
        dto.setLopId(hocSinh.getLopId());
        dto.setHoten(hocSinh.getHoten());
        dto.setNamsinh(hocSinh.getNamsinh());
        dto.setQuequan(hocSinh.getQuequan());
        return dto;
    }

    public HocSinh themHocSinh(ThemHocSinhRequest request) {
        HocSinh hocSinh = new HocSinh();
        hocSinh.setLopId(request.getLopId());
        hocSinh.setHoten(request.getHoten());
        hocSinh.setNamsinh(request.getNamsinh());
        hocSinh.setQuequan(request.getQuequan());
        return hocSinh;
    }

    public HocSinh suaHocSinh(HocSinh hocSinh, SuaHocSinhRequest request) {
        hocSinh.setLopId(request.getLopId());
        hocSinh.setHoten(request.getHoten());
        hocSinh.setNamsinh(request.getNamsinh());
        hocSinh.setQuequan(request.getQuequan());
        return hocSinh;
    }
}
