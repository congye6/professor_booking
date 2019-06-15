package cn.edu.nju.vo;

import java.io.Serializable;

public class UserVO implements Serializable {
    private Integer id;

    private String name;

    private String telephone;

    private String email;

    /**
     * 专家职位
     */
    private String position;

    /**
     * 专家简介
     */
    private String introduction;

    private String school;
    /**
     * 专业
     */
    private String major;

    private String website;

    private String iconUrl;

    /**
     * 国家
     */
    private String country;

    private String researchInterest;

    /**
     * 姓和名，自动根据姓名生成
     */
    private String firstName;

    private String familyName;

    /**
     * 大学排名，自动根据学校名称生成
     */
    private Double institudeRank;

    /**
     * 专业排名，新增
     */
    private Double majorRank;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMajorRank() {
        return majorRank;
    }

    public void setMajorRank(Double majorRank) {
        this.majorRank = majorRank;
    }

    public Double getInstitudeRank() {
        return institudeRank;
    }

    public void setInstitudeRank(Double institudeRank) {
        this.institudeRank = institudeRank;
    }

    public String getResearchInterest() {
        return researchInterest;
    }

    public void setResearchInterest(String researchInterest) {
        this.researchInterest = researchInterest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}