package vn.edu.ntu.dinhtuyen.model;

public class SinhVien {

    private String hoTen;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private String gioHoc;
    private String khoaHoc;
    private String gio;

    public SinhVien(String hoTen, String ngaySinh, String sdt, String diaChi, String gioHoc, String khoaHoc, String gio) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioHoc = gioHoc;
        this.khoaHoc = khoaHoc;
        this.gio = gio;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public SinhVien() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioHoc() {
        return gioHoc;
    }

    public void setGioHoc(String gioHoc) {
        this.gioHoc = gioHoc;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
