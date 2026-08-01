package org.example.completablefuturedemo.dashboardService.repository;

import org.example.completablefuturedemo.dashboardService.entity.DashboardSummary;
import org.example.completablefuturedemo.dashboardService.service.DashboardService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardSummary, Long> {
}
