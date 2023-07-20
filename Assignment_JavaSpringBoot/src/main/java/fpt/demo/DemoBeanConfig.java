package fpt.demo;

import fpt.demo.request.ChiTietSanPhamVM;
import fpt.demo.request.ChucVuVM;
import fpt.demo.request.CuaHangVm;
import fpt.demo.request.DongSpVM;
import fpt.demo.request.GioHangVM;
import fpt.demo.request.HoaDonVM;
import fpt.demo.request.KhachHangVM;
import fpt.demo.request.MauSacVM;
import fpt.demo.request.NhanVienVM;
import fpt.demo.request.NsxVM;
import fpt.demo.request.SanPhamVM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBeanConfig {
    @Bean("ch_vm1")
    public CuaHangVm getCuaHangVM1() {
        CuaHangVm vm = new CuaHangVm();
        vm.setTen(vm.getTen());

        return vm;
    }

    @Bean("nv_vm")
    public NhanVienVM getNhanVienVM2() {
        NhanVienVM vm = new NhanVienVM();
        vm.setMa(vm.getMa());
        vm.setTen(vm.getTen());
        vm.setTenDem(vm.getTenDem());
        vm.setNgaySinh(vm.getNgaySinh());
        vm.setGioiTinh(vm.getGioiTinh());
        vm.setSdt(vm.getSdt());
        vm.setDiaChi(vm.getDiaChi());
        vm.setMatKhau(vm.getMatKhau());
        vm.setTrangThai(vm.getTrangThai());
        vm.setCuaHang(vm.getCuaHang());

        return vm;
    }


    @Bean("kh_vm")

    public KhachHangVM getKhachHangVM() {
        KhachHangVM vm = new KhachHangVM();
        vm.setMa(vm.getMa());
        vm.setTen(vm.getTen());
        vm.setTenDem(vm.getTenDem());
        vm.setNgaySinh(vm.getNgaySinh());
        vm.setSdt(vm.getSdt());
        vm.setThanhPho(vm.getThanhPho());
        vm.setQuocGia(vm.getQuocGia());
        vm.setDiaChi(vm.getDiaChi());
        vm.setMatKhau(vm.getMatKhau());
        return vm;

    }

    @Bean("chucvu_vm")

    public ChucVuVM getChucVuVM() {
        ChucVuVM vm = new ChucVuVM();
        vm.setTen(vm.getTen());
        vm.setMa(vm.getMa());

        return vm;
    }

    @Bean("mausac_vm")

    public MauSacVM getMauSacVM() {
        MauSacVM vm = new MauSacVM();
        vm.setTen(vm.getTen());
        vm.setMa(vm.getMa());

        return vm;
    }

    @Bean("nsx_vm")

    public NsxVM getNsxVM() {
        NsxVM vm = new NsxVM();
        vm.setTen(vm.getTen());
        vm.setMa(vm.getMa());

        return vm;
    }

    @Bean("sanpham_vm")

    public SanPhamVM getSanPhamVM() {
        SanPhamVM vm = new SanPhamVM();
        vm.setTen(vm.getTen());
        vm.setMa(vm.getMa());

        return vm;
    }

    @Bean("dongsp_vm")

    public DongSpVM getDongSpVM() {
        DongSpVM vm = new DongSpVM();
        vm.setTen(vm.getTen());
        vm.setMa(vm.getMa());
        return vm;
    }

    @Bean("hoadon_vm")

    public HoaDonVM getHoaDoVM() {
        HoaDonVM vm = new HoaDonVM();

        vm.setMa(vm.getMa());
        vm.setKhachHang(vm.getKhachHang());
        vm.setNhanVien(vm.getNhanVien());
        vm.setNgayTao(vm.getNgayTao());
        vm.setNgayTao(vm.getNgayTao());
        vm.setNgayTao(vm.getNgayTao());
        vm.setNgayTao(vm.getNgayTao());
        vm.setNgayTao(vm.getNgayTao());
        vm.setDiaChi(vm.getDiaChi());
        vm.setSdt(vm.getSdt());
        vm.setTinhTrang(vm.getTinhTrang());
        return vm;
    }




    @Bean("giohang_vm")


    public GioHangVM getGioHang() {
        GioHangVM vm = new GioHangVM();

        vm.setMa(vm.getMa());
        vm.setKhachHang(vm.getKhachHang());
        vm.setNhanVien(vm.getNhanVien());
        vm.setNgayTao(vm.getNgayTao());
        vm.setNgayThanhToan(vm.getNgayThanhToan());
        vm.setTinhTrang(vm.getTinhTrang());
        vm.setTenNguoiNhan(vm.getTenNguoiNhan());
        vm.setDiaChi(vm.getDiaChi());
        vm.setSdt(vm.getSdt());

        return vm;

    }

    @Bean("chitietSp_vm")

    public ChiTietSanPhamVM getChiTietSp() {
        ChiTietSanPhamVM vm = new ChiTietSanPhamVM();
        vm.setSanPham(vm.getSanPham());
        vm.setNsx(vm.getNsx());
        vm.setMauSac(vm.getMauSac());
        vm.setDongSp(vm.getDongSp());
        vm.setNamBH(vm.getNamBH());
        vm.setMoTa(vm.getMoTa());
        vm.setSoLuongTon(vm.getSoLuongTon());
        vm.setGiaNhap(vm.getGiaNhap());
        vm.setGiaBan(vm.getGiaBan());
        return vm;
    }


}
