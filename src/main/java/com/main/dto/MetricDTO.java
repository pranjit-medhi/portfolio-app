package com.main.dto;

import java.time.LocalDate;

public class MetricDTO {

    private Long id;

    private String page;

    private Integer views;

    private Integer uniqueVisitors;

    private LocalDate recordedDate;

    public MetricDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getUniqueVisitors() {
        return uniqueVisitors;
    }

    public void setUniqueVisitors(Integer uniqueVisitors) {
        this.uniqueVisitors = uniqueVisitors;
    }

    public LocalDate getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(LocalDate recordedDate) {
        this.recordedDate = recordedDate;
    }

    @Override
    public String toString() {
        return "MetricDTO{" +
                "id=" + id +
                ", page='" + page + '\'' +
                ", views=" + views +
                ", uniqueVisitors=" + uniqueVisitors +
                ", recordedDate=" + recordedDate +
                '}';
    }
}
