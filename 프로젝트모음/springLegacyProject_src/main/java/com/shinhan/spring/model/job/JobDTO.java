package com.shinhan.spring.model.job;
/**
 * JobDTO ?��?��?��?�� Jobs ?��?��블의 ?��?��?���? ???��?���? ?��?�� ?��?��?�� ?��?�� 객체?��?��?��.
 */
public class JobDTO {
    private String jobId;       // Job ID
    private String jobTitle;    // Job Title
    private int minSalary;      // Minimum Salary
    private int maxSalary;      // Maximum Salary

    // 기본 ?��?��?��
    public JobDTO() {}

    // 매개�??�� ?��?��?��
    public JobDTO(String jobId, String jobTitle, int minSalary, int maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    // Getter?? Setter 메서?��
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "JobDTO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
    }
}
