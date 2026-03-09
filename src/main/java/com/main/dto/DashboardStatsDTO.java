package com.main.dto;

public class DashboardStatsDTO {
    private Long totalViews;

    private Long totalVisitors;

    private Long blogViews;

    private Long projectViews;

    public DashboardStatsDTO() {
    }

    private DashboardStatsDTO(Builder builder) {
        this.totalViews = builder.totalViews;
        this.totalVisitors = builder.totalVisitors;
        this.blogViews = builder.blogViews;
        this.projectViews = builder.projectViews;
    }

    public Long getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Long totalViews) {
        this.totalViews = totalViews;
    }

    public Long getTotalVisitors() {
        return totalVisitors;
    }

    public void setTotalVisitors(Long totalVisitors) {
        this.totalVisitors = totalVisitors;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public Long getProjectViews() {
        return projectViews;
    }

    public void setProjectViews(Long projectViews) {
        this.projectViews = projectViews;
    }

    // Builder class
    public static class Builder {

        private Long totalViews;
        private Long totalVisitors;
        private Long blogViews;
        private Long projectViews;

        public Builder totalViews(Long totalViews) {
            this.totalViews = totalViews;
            return this;
        }

        public Builder totalVisitors(Long totalVisitors) {
            this.totalVisitors = totalVisitors;
            return this;
        }

        public Builder blogViews(Long blogViews) {
            this.blogViews = blogViews;
            return this;
        }

        public Builder projectViews(Long projectViews) {
            this.projectViews = projectViews;
            return this;
        }

        public DashboardStatsDTO build() {
            return new DashboardStatsDTO(this);
        }
    }

    // Static builder method
    public static Builder builder() {
        return new Builder();
    }
}
