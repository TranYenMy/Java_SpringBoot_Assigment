package fpt.demo.entity;


import fpt.demo.request.CuaHangVm;
import fpt.demo.request.NhanVienVM;
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
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NhanVien")
@Entity
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")

    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;


    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private String trangThai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu chucVu;

    public void loadFromViewModel(NhanVienVM vm)
    {
        this.setMa( vm.getMa() );
        this.setTen( vm.getTen() );
        this.setTenDem( vm.getTenDem() );
        this.setHo( vm.getHo() );
        this.setGioiTinh( vm.getGioiTinh() );
        this.setNgaySinh( vm.getNgaySinh() );
        this.setDiaChi( vm.getDiaChi() );
        this.setSdt( vm.getSdt() );
        this.setMatKhau( vm.getMatKhau() );
        this.setTrangThai( vm.getTrangThai() );
        this.setCuaHang( vm.getCuaHang() );
        this.setChucVu( vm.getChucVu() );

    }
}

