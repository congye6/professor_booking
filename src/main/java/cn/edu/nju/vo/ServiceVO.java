package cn.edu.nju.vo;

import java.sql.Timestamp;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/10
 */
public class ServiceVO {

    private Integer id;
    private Integer professorId;
    private String title;
    private String content;
    private String reserveAddress;
    private Timestamp reserveTime;
    private Timestamp deadline;
    private Integer majorTypeId;
    private Integer serviceTypeId;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceVO{" +
                "id=" + id +
                ", professorId=" + professorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reserveAddress='" + reserveAddress + '\'' +
                ", reserveTime=" + reserveTime +
                ", deadline=" + deadline +
                ", majorTypeId=" + majorTypeId +
                ", serviceTypeId=" + serviceTypeId +
                ", price=" + price +
                '}';
    }
}
