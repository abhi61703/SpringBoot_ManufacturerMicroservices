package com.ust.ManufacturingService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    private String mname;
    private String mcategory;
    private String mwebsite;
    private String mmailid;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMwebsite() {
        return mwebsite;
    }

    public void setMwebsite(String mwebsite) {
        this.mwebsite = mwebsite;
    }

    public String getMcategory() {
        return mcategory;
    }

    public void setMcategory(String mcategory) {
        this.mcategory = mcategory;
    }

    public String getMmailid() {
        return mmailid;
    }

    public void setMmailid(String mmailid) {
        this.mmailid = mmailid;
    }
// Getters and Setters
    // You can use Lombok annotations like @Data for reducing boilerplate code if Lombok is added
}
