package fpt.demo.request;


import fpt.demo.entity.CuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CuaHangVm {
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @NotBlank(message = "ten không được để trống")
    private String ten;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String diaChi;
    @NotBlank(message = "Thành phố không được để trống")
    private String thanhPho ;
    @NotBlank(message = "Quốc gia không được để trống")
    private String quocGia;

    public void loadFromDomainModel(CuaHang domain)
    {
        this.setTen( domain.getTen() );
        this.setMa( domain.getMa() );
        this.setDiaChi( domain.getDiaChi() );
        this.setThanhPho( domain.getThanhPho() );
        this.setQuocGia( domain.getQuocGia() );
    }


}
