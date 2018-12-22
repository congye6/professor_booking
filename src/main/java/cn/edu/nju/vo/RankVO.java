package cn.edu.nju.vo;

import java.io.Serializable;

public class RankVO implements Serializable {
    private Integer id;

    private String institude;

    private Integer rank;

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}