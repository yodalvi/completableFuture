package org.example.completablefuturedemo.dashboardService.controller;

import org.example.completablefuturedemo.dashboardService.dtos.ClaimDashboardDTO;
import org.example.completablefuturedemo.dashboardService.service.DashboardService;
import org.example.completablefuturedemo.dashboardService.util.CsvWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class dashboardController {


    private final DashboardService dashboardService;

    public dashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/export")
    public String exportDashboardData() {
        List<ClaimDashboardDTO> dashboardData = dashboardService.buildDashboardData();
        CsvWriter.writeToCsv(dashboardData, "dashboarddata.csv");
        return "Dashboard data exported to dashboarddata.csv";
    }
}
