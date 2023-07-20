package fpt.demo.repositories;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
}
