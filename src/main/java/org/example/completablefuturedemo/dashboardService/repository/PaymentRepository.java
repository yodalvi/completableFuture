package org.example.completablefuturedemo.dashboardService.repository;

import org.example.completablefuturedemo.dashboardService.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
