package cn.edu.nju.vo;

import java.sql.Timestamp;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
public class OrderVO {

    private Integer id;
    private Integer userId;
    private Integer serviceId;
    private Timestamp createTime;

    private String title;
    private String content;
    private String reserveAddress;
    private Timestamp reserveTime;
    private Timestamp deadline;
    private Integer majorTypeId;
    private Integer serviceTypeId;

    private String name;
    private String telephone;
    private String email;
    private String position;
    private String introduction;
    private String school;
    private String major;
    private String website;
    private String iconUrl;
    private String country;
    private String researchInterest;
    private String firstName;
    private String familyName;
    private Integer institudeRank;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReserveAddress() {
        return reserveAddress;
    }

    public void setReserveAddress(String reserveAddress) {
        this.reserveAddress = reserveAddress;
    }

    public Timestamp getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Timestamp reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Integer getMajorTypeId() {
        return majorTypeId;
    }

    public void setMajorTypeId(Integer majorTypeId) {
        this.majorTypeId = majorTypeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Integer getInstitudeRank() {
        return institudeRank;
    }

    public void setInstitudeRank(Integer institudeRank) {
        this.institudeRank = institudeRank;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reserveAddress='" + reserveAddress + '\'' +
                ", reserveTime=" + reserveTime +
                ", deadline=" + deadline +
                ", majorTypeId=" + majorTypeId +
                ", serviceTypeId=" + serviceTypeId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", introduction='" + introduction + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", website='" + website + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", country='" + country + '\'' +
                ", researchInterest='" + researchInterest + '\'' +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", institudeRank=" + institudeRank +
                '}';
    }
}
