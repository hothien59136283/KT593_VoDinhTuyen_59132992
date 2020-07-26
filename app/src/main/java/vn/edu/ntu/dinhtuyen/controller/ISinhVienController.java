package vn.edu.ntu.dinhtuyen.controller;

import java.util.List;

import vn.edu.ntu.dinhtuyen.model.SinhVien;

public interface ISinhVienController {

    public List<SinhVien> getAll();
    public void addToList(SinhVien sinhVien);
}
