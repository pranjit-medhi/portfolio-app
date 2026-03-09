package com.main.service.impl;

import com.main.dto.DashboardStatsDTO;
import com.main.dto.MetricDTO;
import com.main.entity.Metric;
import com.main.repository.MetricRepository;
import com.main.service.MetricsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MetricsServiceImpl implements MetricsService {
    private final MetricRepository repository;
    private final ModelMapper mapper;


    public MetricsServiceImpl(MetricRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void recordVisit(String page) {

        LocalDate today = LocalDate.now();

        Metric metric = repository
                .findByPageAndRecordedDate(page, today)
                .orElse(null);

        if (metric == null) {

            metric = Metric.builder()
                    .page(page)
                    .views(1)
                    .uniqueVisitors(1)
                    .recordedDate(today)
                    .build();

        } else {

            metric.setViews(metric.getViews() + 1);
        }

        repository.save(metric);
    }


    @Override
    public DashboardStatsDTO getDashboardStats() {

        List<Metric> metrics = repository.findAll();

        long totalViews = metrics.stream()
                .mapToLong(Metric::getViews)
                .sum();

        long totalVisitors = metrics.stream()
                .mapToLong(Metric::getUniqueVisitors)
                .sum();

        long blogViews = metrics.stream()
                .filter(m -> m.getPage().equals("blog"))
                .mapToLong(Metric::getViews)
                .sum();

        long projectViews = metrics.stream()
                .filter(m -> m.getPage().equals("projects"))
                .mapToLong(Metric::getViews)
                .sum();

        return DashboardStatsDTO.builder()
                .totalViews(totalViews)
                .totalVisitors(totalVisitors)
                .blogViews(blogViews)
                .projectViews(projectViews)
                .build();

    }

    @Override
    public List<MetricDTO> getTodayStats() {

        LocalDate today = LocalDate.now();

        return repository.findByRecordedDate(today)
                .stream()
                .map(metric -> mapper.map(metric, MetricDTO.class))
                .toList();
    }
}
