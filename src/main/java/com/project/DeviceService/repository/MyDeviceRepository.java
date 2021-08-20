package com.project.DeviceService.repository;

import com.project.DeviceService.entity.MyDeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDeviceRepository extends JpaRepository<MyDeviceEntity, Long> {

}
