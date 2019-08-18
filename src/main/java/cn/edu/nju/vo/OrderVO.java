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
    private int studentStatus;
    private int teacherStatus;

    private String name;
    private String phone;
    private String email;
    private String company;

    private String title;
    private String content;
    private String reserveAddress;
    private Timestamp reserveTime;
    private Timestamp deadline;
    private Integer majorTypeId;
    private Integer serviceTypeId;

    private String professorName;
    private String professorMajor;
    private String professorSchool;
    private String iconUrl;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorMajor() {
        return professorMajor;
    }

    public void setProfessorMajor(String professorMajor) {
        this.professorMajor = professorMajor;
    }

    public String getProfessorSchool() {
        return professorSchool;
    }

    public void setProfessorSchool(String professorSchool) {
        this.professorSchool = professorSchool;
    }

    public int getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(int studentStatus) {
        this.studentStatus = studentStatus;
    }

    public int getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(int teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", createTime=" + createTime +
                ", studentStatus=" + studentStatus +
                ", teacherStatus=" + teacherStatus +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reserveAddress='" + reserveAddress + '\'' +
                ", reserveTime=" + reserveTime +
                ", deadline=" + deadline +
                ", majorTypeId=" + majorTypeId +
                ", serviceTypeId=" + serviceTypeId +
                ", professorName='" + professorName + '\'' +
                ", professorMajor='" + professorMajor + '\'' +
                ", professorSchool='" + professorSchool + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
