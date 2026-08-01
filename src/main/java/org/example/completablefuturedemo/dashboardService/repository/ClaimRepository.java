package org.example.completablefuturedemo.dashboardService.repository;

import org.example.completablefuturedemo.dashboardService.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
