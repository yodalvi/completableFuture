package org.example.completablefuturedemo.dashboardService.util;

import org.example.completablefuturedemo.dashboardService.dtos.ClaimDashboardDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvWriter {
    public static void writeToCsv(List<ClaimDashboardDTO> data, String fileName){
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write header
            writer.append("ClaimId,ClaimStatus,PaymentStatus,FraudStatus,NotificationMessage\n");

            // Write rowsx`
            for (ClaimDashboardDTO dto : data) {
                writer.append(dto.Id().toString()).append(",");
                writer.append(dto.claimStatus()).append(",");
                writer.append(dto.paymentStatus()).append(",");
                writer.append(dto.fraudStatus()).append(",");
                writer.append(dto.notificationMessage()).append("\n");
            }

            writer.flush();
            System.out.println("CSV file created: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
