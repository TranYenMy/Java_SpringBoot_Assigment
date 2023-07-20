package fpt.demo.request;

import fpt.demo.entity.GioHang;
import fpt.demo.entity.HoaDon;
import fpt.demo.entity.KhachHang;
import fpt.demo.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GioHangVM {
    @NotBlank(message = "Không được để trống")
    private  String ma;
    @NotBlank(message = "Không được để trống")
    private  String ngayTao;
    @NotBlank(message = "Không được để trống")
    private  String ngayThanhToan;
    @NotBlank(message = "Không được để trống")
    private int  tinhTrang;
    @NotBlank(message = "Không được để trống")
    private  String tenNguoiNhan;
    @NotBlank(message = "Không được để trống")
    private  String diaChi;
    @NotBlank(message = "Không được để trống")
    private  String sdt;
    @NotBlank(message = "Không được để trống")
    private KhachHang khachHang;
    @NotBlank(message = "Không được để trống")
    private NhanVien nhanVien;

    public void loadFromDomainModel(GioHang domain) {
        this.setMa(domain.getMa());
        this.setKhachHang(domain.getKhachHang());
        this.setNhanVien(domain.getNhanVien());
        this.setNgayTao(domain.getNgayTao());
        this.setNgayThanhToan(domain.getNgayThanhToan());
        this.setTinhTrang(domain.getTinhTrang());
        this.setTenNguoiNhan(domain.getTenNguoiNhan());
        this.setDiaChi(domain.getDiaChi());
        this.setSdt(domain.getSdt());



    }
}
