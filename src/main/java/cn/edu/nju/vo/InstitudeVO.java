package cn.edu.nju.vo;

import java.io.Serializable;

/**
 * 大学信息
 */
public class InstitudeVO implements Serializable {
    private Integer id;

    /**
     * 学校名称
     */
    private String institude;

    /**
     * 排名
     */
    private Double rank;

    /**
     * 所属国家
     */
    private String country;

    private String icon;

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

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}