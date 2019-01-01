package cn.edu.nju.vo;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
public class ExpertServiceVO {

    private UserVO expert;
    private List<ServiceVO> serviceList;

    public UserVO getExpert() {
        return expert;
    }

    public void setExpert(UserVO expert) {
        this.expert = expert;
    }

    public List<ServiceVO> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceVO> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "ExpertServiceVO{" +
                "expert=" + expert +
                ", serviceVOList=" + serviceList +
                '}';
    }
}
