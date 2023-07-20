package fpt.demo.repositories;

import fpt.demo.entity.ChiTietSanPham;
import fpt.demo.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChiTietSpRepository extends JpaRepository<ChiTietSanPham, UUID> {
}
