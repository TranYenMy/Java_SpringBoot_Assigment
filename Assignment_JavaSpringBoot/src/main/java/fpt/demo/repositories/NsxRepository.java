package fpt.demo.repositories;

import fpt.demo.entity.DongSp;
import fpt.demo.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NsxRepository extends JpaRepository<Nsx, UUID> {
}
