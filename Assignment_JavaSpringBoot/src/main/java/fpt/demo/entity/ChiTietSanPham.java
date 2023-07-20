package fpt.demo.entity;

import fpt.demo.request.ChiTietSanPhamVM;
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
@Table(name = "ChiTietSP")
@Entity
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private Nsx nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSp dongSp;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private String giaNhap;

    @Column(name = "GiaBan")
    private String giaBan;

    public void loadFromViewModel(ChiTietSanPhamVM vm) {

        vm.setSanPham(vm.getSanPham());
        vm.setNsx(vm.getNsx());
        vm.setMauSac(vm.getMauSac());
        vm.setDongSp(vm.getDongSp());
        vm.setNamBH(vm.getNamBH());
        vm.setMoTa(vm.getMoTa());
        vm.setSoLuongTon(vm.getSoLuongTon());
        vm.setGiaNhap(vm.getGiaNhap());
        vm.setGiaBan(vm.getGiaBan());
    }

    }



