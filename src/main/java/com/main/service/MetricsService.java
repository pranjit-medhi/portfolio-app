package com.main.service;

import com.main.dto.DashboardStatsDTO;
import com.main.dto.MetricDTO;

import java.util.List;

public interface MetricsService {
    void recordVisit(String page);

    DashboardStatsDTO getDashboardStats();

    List<MetricDTO> getTodayStats();
}
