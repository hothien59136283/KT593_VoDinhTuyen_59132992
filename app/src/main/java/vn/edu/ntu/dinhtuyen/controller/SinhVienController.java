package vn.edu.ntu.dinhtuyen.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.dinhtuyen.model.SinhVien;

public class SinhVienController extends Application implements ISinhVienController {

    private List<SinhVien> list = new ArrayList<>();

    public SinhVienController() {
        list.add(new SinhVien("Thanh Thiện", "20/10/1999", "01234", "22 Củ Chi", "Sáng", "java", "10"));
    }

    @Override
    public List<SinhVien> getAll() {
        return list;
    }

    @Override
    public void addToList(SinhVien sinhVien) {
        list.add(sinhVien);
    }
}
