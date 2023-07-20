package fpt.demo.repositories;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
}
