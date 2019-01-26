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
     * 教师信息id(爬取信息表中的id）
     */
    private Integer teacherInfoId;

    public FollowVO(String studentWechatId, Integer teacherInfoId) {
        this.studentWechatId = studentWechatId;
        this.teacherInfoId = teacherInfoId;
    }

    public FollowVO() {
    }

    private static final long serialVersionUID = 1L;

    public String getStudentWechatId() {
        return studentWechatId;
    }

    public void setStudentWechatId(String studentWechatId) {
        this.studentWechatId = studentWechatId == null ? null : studentWechatId.trim();
    }

    public Integer getTeacherInfoId() {
        return teacherInfoId;
    }

    public void setTeacherInfoId(Integer teacherInfoId) {
        this.teacherInfoId = teacherInfoId;
    }
}