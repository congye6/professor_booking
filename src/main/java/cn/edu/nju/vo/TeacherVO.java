package cn.edu.nju.vo;

import java.io.Serializable;

public class TeacherVO implements Serializable {
    private Integer id;

    private String wechatId;

    private String wechatIconUrl;

    private Integer infoId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getWechatIconUrl() {
        return wechatIconUrl;
    }

    public void setWechatIconUrl(String wechatIconUrl) {
        this.wechatIconUrl = wechatIconUrl == null ? null : wechatIconUrl.trim();
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }
}