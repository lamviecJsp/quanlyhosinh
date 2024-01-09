package com.example.demo.controller;

import com.example.demo.payload.dto.HocSinhDTO;
import com.example.demo.payload.request.SuaHocSinhRequest;
import com.example.demo.payload.request.ThemHocSinhRequest;
import com.example.demo.payload.respopnse.ResponseObject;
import com.example.demo.service.implement.HocSinhService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HocSinhController {
    private final HocSinhService _hocSinhService;

    public HocSinhController(HocSinhService hocSinhService) {
        _hocSinhService = hocSinhService;
    }

    @PostMapping(value = "themhocsinh", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HocSinhDTO> themHocSinh(@RequestBody ThemHocSinhRequest request) {
        return _hocSinhService.themHocSinh(request);
    }

    @DeleteMapping(value = "xoahocsinh", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaHocSinh(@RequestParam int hocSinhId) {
        return _hocSinhService.xoaHocSinh(hocSinhId);
    }

    @PutMapping(value = "suahocsinh", produces = MediaType.APPLICATION_JSON_VALUE)
    public String suaHocSinh(@RequestParam int hocsinhid, @RequestBody SuaHocSinhRequest request) {
        return _hocSinhService.suaHocSinh(hocsinhid, request);
    }
}
