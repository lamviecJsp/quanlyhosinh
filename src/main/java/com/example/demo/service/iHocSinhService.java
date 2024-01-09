package com.example.demo.service;

import com.example.demo.payload.dto.HocSinhDTO;
import com.example.demo.payload.request.SuaHocSinhRequest;
import com.example.demo.payload.request.ThemHocSinhRequest;
import com.example.demo.payload.respopnse.ResponseObject;

public interface iHocSinhService {
    ResponseObject<HocSinhDTO> themHocSinh(ThemHocSinhRequest request);

    String xoaHocSinh(int hocSinhId);

    String suaHocSinh(int hocsinhid, SuaHocSinhRequest request);
}
