package fpt.demo.repositories;

import fpt.demo.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID>{
}
