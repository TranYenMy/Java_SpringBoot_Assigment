package fpt.demo.entity;

import fpt.demo.request.ChucVuVM;
import fpt.demo.request.DongSpVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DongSp {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    public void loadFromViewModel(DongSpVM vm)
    {
        this.setMa( vm.getMa() );
        this.setTen( vm.getTen() );

    }

}
