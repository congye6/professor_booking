package cn.edu.nju.vo;

import java.io.Serializable;

public class StudentVO implements Serializable {
    private Integer id;

    private String wechatId;

    private String wechatIconUrl;

    private String name;

    private String phone;

    private String email;

    private String company;

    /**
     * 是否已审核
     */
    private Boolean isAudited;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Boolean getAudited() {
        return isAudited;
    }

    public void setAudited(Boolean audited) {
        isAudited = audited;
    }
}