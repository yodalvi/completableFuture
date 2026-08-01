package org.example.completablefuturedemo.dashboardService.service;

import org.example.completablefuturedemo.dashboardService.dtos.ClaimDashboardDTO;
import org.example.completablefuturedemo.dashboardService.entity.Claim;
import org.example.completablefuturedemo.dashboardService.entity.FraudCheck;
import org.example.completablefuturedemo.dashboardService.entity.Notification;
import org.example.completablefuturedemo.dashboardService.entity.Payment;
import org.example.completablefuturedemo.dashboardService.repository.*;
import org.example.completablefuturedemo.dashboardService.util.CsvWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DashboardService {

    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private DashboardRepository dashboardRepository;
    @Autowired
    private FraudCheckRepository fraudCheckRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    public List<ClaimDashboardDTO> buildDashboardData() {
            CompletableFuture<List<Claim>> fetchClaim = CompletableFuture.supplyAsync(
                    () -> claimRepository.findAll()
            );

            CompletableFuture<List<FraudCheck>> fetchFraudCheck = CompletableFuture.supplyAsync(
                    ()-> fraudCheckRepository.findAll()
            );

            CompletableFuture<List<Payment>> fetchPayment = CompletableFuture.supplyAsync(
                    ()-> paymentRepository.findAll()
            );

            CompletableFuture<List<Notification>> fetchNotification = CompletableFuture.supplyAsync(
                    ()-> notificationRepository.findAll()
            );

            CompletableFuture<Void> allTask = CompletableFuture.allOf(
                    fetchClaim,fetchFraudCheck,fetchPayment,fetchNotification
            );

            List<Claim> claims = fetchClaim.join();
            List<FraudCheck> frauds = fetchFraudCheck.join();
            List<Payment> payments = fetchPayment.join();
            List<Notification> notifs = fetchNotification.join();

            return claims.stream()
                    .map(claim -> new ClaimDashboardDTO(
                                claim.getId(),
                                claim.getStatus(),
                                findPaymentStatusFor(claim.getId(), payments),
                                findFraudStatusFor(claim.getId(), frauds),
                                findNotificationFor(claim.getId(), notifs)
                    ))
                    .toList();

    }

    private String findNotificationFor(Long claimId, List<Notification> notifs){

        return notifs.stream()
                .filter( n -> n.getId().equals(claimId))
                .map(Notification::getMessage)
                .findFirst()
                .orElse("N/A");
    }

    private String findPaymentStatusFor(Long claimId, List<Payment> payments) {
        return payments.stream()
                .filter(p -> p.getId().equals(claimId))
                .map(Payment::getStatus)
                .findFirst()
                .orElse("N/A");
    }

    private String findFraudStatusFor(Long claimId, List<FraudCheck> frauds) {
        return frauds.stream()
                .filter(f -> f.getId().equals(claimId))
                .map(FraudCheck::getResult)
                .findFirst()
                .orElse("N/A");
    }

//    CsvWriter.writeToCsv(buildDashboardData(), "dashboarddata.csv");
}
