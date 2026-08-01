package org.example.completablefuturedemo.dashboardService.repository;

import org.example.completablefuturedemo.dashboardService.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
