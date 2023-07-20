package fpt.demo.repositories;

import fpt.demo.entity.ChucVu;
import fpt.demo.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongSpRepository extends JpaRepository<DongSp, UUID> {

}
