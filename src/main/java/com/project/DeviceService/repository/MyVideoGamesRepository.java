package com.project.DeviceService.repository;

import com.project.DeviceService.entity.MyVideoGamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyVideoGamesRepository extends JpaRepository<MyVideoGamesEntity, Long> {
}
