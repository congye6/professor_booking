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

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", createTime=" + createTime +
                '}';
    }
}
