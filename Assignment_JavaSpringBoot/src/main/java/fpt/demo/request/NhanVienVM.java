package fpt.demo.request;

import fpt.demo.entity.ChucVu;
import fpt.demo.entity.CuaHang;
import fpt.demo.entity.NhanVien;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhanVienVM {
    @NotBlank(message = "Khong duoc de trong")
    private String ma;

    @NotBlank(message = "Khong duoc de trong")
    private String ten;

    @NotBlank(message = "Khong duoc de trong")
    private String tenDem;

    @NotBlank(message = "Khong duoc de trong")
    private String ho;

    @NotBlank(message = "Khong duoc de trong")
    private String gioiTinh;

    @NotBlank(message = "Khong duoc de trong")
    private String ngaySinh;

    @NotBlank(message = "Khong duoc de trong")
    private String diaChi;

    @NotBlank(message = "Khong duoc de trong")
    private String sdt;

    @NotBlank(message = "Khong duoc de trong")
    private String matKhau;

    @NotBlank(message = "Khong duoc de trong")
    private String trangThai;

    private CuaHang cuaHang;
    private ChucVu chucVu;
    public void loadFromDomainModel(NhanVien domain)
    {
        this.setMa( domain.getMa() );
        this.setTen( domain.getTen() );
        this.setTenDem( domain.getTenDem() );
        this.setHo( domain.getHo() );
        this.setGioiTinh( domain.getGioiTinh() );
        this.setNgaySinh( domain.getNgaySinh() );
        this.setDiaChi( domain.getDiaChi() );
        this.setSdt( domain.getSdt() );
        this.setMatKhau( domain.getMatKhau() );
        this.setTrangThai( domain.getTrangThai() );
        this.setCuaHang( domain.getCuaHang() );

    }
}
