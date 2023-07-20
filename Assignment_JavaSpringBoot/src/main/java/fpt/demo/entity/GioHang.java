package fpt.demo.entity;

import fpt.demo.request.GioHangVM;
import fpt.demo.request.HoaDonVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang")
@Entity
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH", referencedColumnName = "Id")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private NhanVien nhanVien;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private int tinhTrang;


    public void loadFromViewModel(GioHangVM vm) {
        this.setMa(vm.getMa());
        this.setKhachHang(vm.getKhachHang());
        this.setNhanVien(vm.getNhanVien());
        this.setNgayTao(vm.getNgayTao());
        this.setNgayThanhToan(vm.getNgayThanhToan());
        this.setTinhTrang(vm.getTinhTrang());
        this.setTenNguoiNhan(vm.getTenNguoiNhan());
        this.setDiaChi(vm.getDiaChi());
        this.setSdt(vm.getSdt());


    }
}
