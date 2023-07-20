package fpt.demo.request;

import fpt.demo.entity.KhachHang;
import fpt.demo.entity.NhanVien;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class KhachHangVM {

    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    private String ho;

    @NotBlank(message = "Không được để trống")
    private String ngaySinh;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    private String thanhPho;

    @NotBlank(message = "Không được để trống")
    private String quocGia;


    @NotBlank(message = "Không được để trống")
    private String matKhau;


    public void loadFromDomainModel(KhachHang domain)
    {
        this.setMa( domain.getMa() );
        this.setTen( domain.getTen() );
        this.setTenDem( domain.getTenDem() );
        this.setHo( domain.getHo() );
        this.setNgaySinh( domain.getNgaySinh() );
        this.setDiaChi( domain.getDiaChi() );
        this.setSdt( domain.getSdt() );
        this.setThanhPho(domain.getThanhPho());
        this.setQuocGia(domain.getQuocGia());
        this.setMatKhau( domain.getMatKhau() );

    }


}
