package fpt.demo.request;

import fpt.demo.entity.Nsx;
import fpt.demo.entity.SanPham;
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
public class NsxVM {
    @NotBlank(message = "Mã không được để trống")
    private String ma;
    @NotBlank(message = "ten không được để trống")
    private String ten;

    public void loadFromDomainModel(Nsx domain) {
        this.setTen(domain.getTen());
        this.setMa(domain.getMa());

    }
}
