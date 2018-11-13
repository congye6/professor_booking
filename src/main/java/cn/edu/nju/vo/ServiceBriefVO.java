package cn.edu.nju.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
public class ServiceBriefVO {

    private ServiceVO serviceVO;
    private Integer professorId;
    private String professorName;
    private String iconUrl;
    private String position;

    public ServiceVO getServiceVO() {
        return serviceVO;
    }

    public void setServiceVO(ServiceVO serviceVO) {
        this.serviceVO = serviceVO;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ServiceBriefVO{" +
                "serviceVO=" + serviceVO +
                ", professorId=" + professorId +
                ", professorName='" + professorName + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
