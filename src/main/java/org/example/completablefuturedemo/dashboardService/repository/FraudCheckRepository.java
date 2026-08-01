package org.example.completablefuturedemo.dashboardService.repository;

import org.example.completablefuturedemo.dashboardService.entity.FraudCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckRepository extends JpaRepository<FraudCheck, Long> {
}
