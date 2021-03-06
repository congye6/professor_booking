package cn.edu.nju.vo;

import java.io.Serializable;

public class MajorRankVO implements Serializable {
    private Integer id;

    private String institude;

    private String major;

    /**
     * rank类型改成double
     */
    private Double rank;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitude() {
        return institude;
    }

    public void setInstitude(String institude) {
        this.institude = institude == null ? null : institude.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }
}