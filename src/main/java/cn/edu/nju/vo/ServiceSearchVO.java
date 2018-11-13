package cn.edu.nju.vo;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
public class ServiceSearchVO {

    private List<UserVO> professorList;
    private List<ServiceVO> serviceList;

    public List<UserVO> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<UserVO> professorList) {
        this.professorList = professorList;
    }

    public List<ServiceVO> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceVO> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "ServiceSearchVO{" +
                "professorList=" + professorList +
                ", serviceList=" + serviceList +
                '}';
    }
}
