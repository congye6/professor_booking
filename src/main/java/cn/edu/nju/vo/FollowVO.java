package cn.edu.nju.vo;

import java.io.Serializable;

/**
 * 关注的关联信息
 */
public class FollowVO implements Serializable {

    /**
     * 学生微信id
     */
    private String studentWechatId;

    /**
     * 教师微信id(系统自动查找)
     */
    private String teacherWechatId;

    /**
     * 教师信息id(爬取信息表中的id）
     */
    private Integer teacherInfoId;

    private static final long serialVersionUID = 1L;

    public String getStudentWechatId() {
        return studentWechatId;
    }

    public void setStudentWechatId(String studentWechatId) {
        this.studentWechatId = studentWechatId == null ? null : studentWechatId.trim();
    }

    public String getTeacherWechatId() {
        return teacherWechatId;
    }

    public void setTeacherWechatId(String teacherWechatId) {
        this.teacherWechatId = teacherWechatId == null ? null : teacherWechatId.trim();
    }

    public Integer getTeacherInfoId() {
        return teacherInfoId;
    }

    public void setTeacherInfoId(Integer teacherInfoId) {
        this.teacherInfoId = teacherInfoId;
    }
}