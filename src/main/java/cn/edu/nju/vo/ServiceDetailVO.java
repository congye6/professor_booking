package cn.edu.nju.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
public class ServiceDetailVO {

    private ServiceVO service;
    private UserVO user;

    public ServiceVO getServiceVO() {
        return service;
    }

    public void setServiceVO(ServiceVO serviceVO) {
        this.service = serviceVO;
    }

    public UserVO getUserVO() {
        return user;
    }

    public void setUserVO(UserVO userVO) {
        this.user = userVO;
    }

    @Override
    public String toString() {
        return "ServiceDetailVO{" +
                "serviceVO=" + service +
                ", userVO=" + user +
                '}';
    }
}
