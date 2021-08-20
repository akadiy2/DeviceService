package com.project.DeviceService.repository;

import com.project.DeviceService.entity.ConsoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<ConsoleEntity, Long> {
}
