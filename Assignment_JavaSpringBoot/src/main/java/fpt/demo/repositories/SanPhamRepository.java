package fpt.demo.repositories;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
