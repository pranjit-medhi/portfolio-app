package com.main.controller;

import com.main.dto.DashboardStatsDTO;
import com.main.dto.MetricDTO;
import com.main.service.MetricsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/metrics")
public class MetricsController {
    private final MetricsService service;

    public MetricsController(MetricsService service) {
        this.service = service;
    }

    @PostMapping("/visit")
    public void recordVisit(@RequestParam String page) {
        service.recordVisit(page);
    }

    @GetMapping("/dashboard")
    public DashboardStatsDTO getDashboardStats() {
        return service.getDashboardStats();
    }

    @GetMapping("/today")
    public List<MetricDTO> getTodayStats() {
        return service.getTodayStats();
    }
}
