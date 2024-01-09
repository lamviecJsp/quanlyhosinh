package com.example.demo.service.implement;

import com.example.demo.payload.converter.HocSinhConverter;
import com.example.demo.payload.dto.HocSinhDTO;
import com.example.demo.payload.request.SuaHocSinhRequest;
import com.example.demo.payload.request.ThemHocSinhRequest;
import com.example.demo.payload.respopnse.ResponseObject;
import com.example.demo.repository.HocSinhRepo;
import com.example.demo.repository.LopRepo;
import com.example.demo.service.iHocSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class HocSinhService implements iHocSinhService {
    @Autowired
    private HocSinhConverter _hocSinhConverter;
    @Autowired
    private HocSinhRepo _hocSinhRepo;
    @Autowired
    private LopRepo _lopRepo;

    public ResponseObject<HocSinhDTO> _hocSinhDTOResponseObject;

    public HocSinhService() {
        _hocSinhDTOResponseObject = new ResponseObject<HocSinhDTO>();
    }

    public ResponseObject<HocSinhDTO> themHocSinh(ThemHocSinhRequest request) {
        var lop = _lopRepo.findAll().stream().filter(x -> x.getId() == request.getLopId()).findFirst();
        if (lop.isEmpty()) {
            return _hocSinhDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Lớp không tồn tại", null);
        }
        if (lop.get().getSiso() >= 20) {
            return _hocSinhDTOResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Lớp đã đủ học sinh", null);
        }
        var hocSinhThem = _hocSinhConverter.themHocSinh(request);
        _hocSinhRepo.save(hocSinhThem);
        lop.get().setSiso(lop.get().getSiso() + 1);
        _lopRepo.save(lop.get());
        return _hocSinhDTOResponseObject.responseSuccess("Thêm học sinh thành công", _hocSinhConverter.entityToDTO(hocSinhThem));
    }

    public String xoaHocSinh(int hocSinhId) {
        var hocSinh = _hocSinhRepo.findAll().stream().filter(x -> x.getId() == hocSinhId).findFirst();
        if (hocSinh.isEmpty()) {
            return "Không tìm thấy học sinh này";
        }
        _hocSinhRepo.delete(hocSinh.get());
        return "Xoá học sinh thành công";
    }

    public String suaHocSinh(int hocsinhid, SuaHocSinhRequest request) {
        var hocSinh = _hocSinhRepo.findAll().stream().filter(x -> x.getId() == hocsinhid).findFirst();
        if (hocSinh.isEmpty()) {
            return "Không tìm thấy học sinh này";
        }
        var hocSinhSua = _hocSinhConverter.suaHocSinh(hocSinh.get(), request);
        _hocSinhRepo.save(hocSinhSua);
        return "Sửa học sinh thành công";
    }
}
