package cn.edu.nju.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/03/01
 */
public class OrderModifyVO {

    private Integer id;
    private Integer userId;
    private Integer serviceId;

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
}
