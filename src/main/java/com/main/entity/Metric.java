package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String page;

    private Integer views;

    private Integer uniqueVisitors;

    private LocalDate recordedDate;

    public Metric() {
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
        return "Metric{" +
                "id=" + id +
                ", page='" + page + '\'' +
                ", views=" + views +
                ", uniqueVisitors=" + uniqueVisitors +
                ", recordedDate=" + recordedDate +
                '}';
    }

    private Metric(Builder builder) {
        this.page = builder.page;
        this.views = builder.views;
        this.uniqueVisitors = builder.uniqueVisitors;
        this.recordedDate = builder.recordedDate;
    }
    public static class Builder {

        private String page;
        private Integer views;
        private Integer uniqueVisitors;
        private LocalDate recordedDate;

        public Builder page(String page) {
            this.page = page;
            return this;
        }

        public Builder views(Integer views) {
            this.views = views;
            return this;
        }

        public Builder uniqueVisitors(Integer uniqueVisitors) {
            this.uniqueVisitors = uniqueVisitors;
            return this;
        }

        public Builder recordedDate(LocalDate recordedDate) {
            this.recordedDate = recordedDate;
            return this;
        }

        public Metric build() {
            return new Metric(this);
        }
    }

    // Static builder() method
    public static Builder builder() {
        return new Builder();
    }
}
