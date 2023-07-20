package fpt.demo.entity;


import fpt.demo.request.CuaHangVm;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuaHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho ;

    @Column(name = "QuocGia")
    private String quocGia;

    public void loadFromViewModel(CuaHangVm vm)
    {
        this.setMa( vm.getMa() );
        this.setTen( vm.getTen() );
        this.setDiaChi( vm.getDiaChi() );
        this.setThanhPho( vm.getThanhPho() );
        this.setQuocGia( vm.getQuocGia() );
    }
}
