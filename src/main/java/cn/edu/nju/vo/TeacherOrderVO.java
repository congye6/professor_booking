package cn.edu.nju.vo;

/**
 * 教师查看的预约信息
 * Created by cong on 2019-01-11.
 */
public class TeacherOrderVO {

    /**
     * 服务信息
     */
    private ServiceVO service;

    /**
     * 学生信息
     */
    private StudentVO student;

    public TeacherOrderVO() {
    }

    public TeacherOrderVO(ServiceVO service, StudentVO student) {
        this.service = service;
        this.student = student;
    }

    public ServiceVO getService() {
        return service;
    }

    public void setService(ServiceVO service) {
        this.service = service;
    }

    public StudentVO getStudent() {
        return student;
    }

    public void setStudent(StudentVO student) {
        this.student = student;
    }
}
