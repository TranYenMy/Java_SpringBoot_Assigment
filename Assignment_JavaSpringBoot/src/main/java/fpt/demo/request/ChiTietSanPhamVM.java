package fpt.demo.request;

import fpt.demo.entity.ChiTietSanPham;
import fpt.demo.entity.DongSp;
import fpt.demo.entity.MauSac;
import fpt.demo.entity.Nsx;
import fpt.demo.entity.SanPham;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPhamVM {

    @NotBlank(message = "Không được để trống")
    private SanPham sanPham;
    @NotBlank(message = "Không được để trống")
    private Nsx nsx;

    @NotBlank(message = "Không được để trống")
    private MauSac mauSac;
    @NotBlank(message = "Không được để trống")
    private DongSp dongSp;
    @NotBlank(message = "Không được để trống")
    private int namBH;
    @NotBlank(message = "Không được để trống")
    private String moTa;
    @NotBlank(message = "Không được để trống")
    private int soLuongTon;
    @NotBlank(message = "Không được để trống")
    private String giaNhap;
    @NotBlank(message = "Không được để trống")
    private String giaBan;


    public void loadFromDomainModel(ChiTietSanPham domain) {

        this.setSanPham(domain.getSanPham());
        this.setNsx(domain.getNsx());
        this.setMauSac(domain.getMauSac());
        this.setDongSp(domain.getDongSp());
        this.setNamBH(domain.getNamBH());
        this.setMoTa(domain.getMoTa());
        this.setSoLuongTon(domain.getSoLuongTon());
        this.setGiaNhap(domain.getGiaNhap());
        this.setGiaBan(domain.getGiaBan());
    }
}
