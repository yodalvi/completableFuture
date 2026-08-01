package org.example.completablefuturedemo.dashboardService.dtos;

public record ClaimDashboardDTO (
    Long Id ,
    String claimStatus,
    String paymentStatus,
    String fraudStatus,
    String notificationMessage

){}