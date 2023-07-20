package fpt.demo.repositories;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
}
