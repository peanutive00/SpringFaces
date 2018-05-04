package com.SpringFaces.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
@Table(name = "todo")
public class Todo {

    private int id;
    private String jobName;
    private String jobDescription;
    private java.sql.Date targetDate;
    
    private boolean selected = false;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "job_name", nullable = false)
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Column(name = "job_description", nullable = false)
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    @Column(name = "target_date", nullable = false)
    public Date getTargetDate(){
        return targetDate;
    }
    
    public void setTargetDate(Date targetDate){
        if(targetDate != null)
            this.targetDate = new java.sql.Date(targetDate.getTime());
    }
    
    @Transient
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
}
