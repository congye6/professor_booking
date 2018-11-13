package cn.edu.nju.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
public class ServiceDetailVO {

    private ServiceVO serviceVO;
    private UserVO userVO;

    public ServiceVO getServiceVO() {
        return serviceVO;
    }

    public void setServiceVO(ServiceVO serviceVO) {
        this.serviceVO = serviceVO;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    @Override
    public String toString() {
        return "ServiceDetailVO{" +
                "serviceVO=" + serviceVO +
                ", userVO=" + userVO +
                '}';
    }
}
