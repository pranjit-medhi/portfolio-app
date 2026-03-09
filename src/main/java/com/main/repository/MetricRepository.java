package com.main.repository;

import com.main.entity.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
    Optional<Metric> findByPageAndRecordedDate(String page, LocalDate date);

    List<Metric> findByRecordedDate(LocalDate date);
}
