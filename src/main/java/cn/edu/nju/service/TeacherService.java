package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import cn.edu.nju.vo.TeacherVO;

/**
 * 教师用户
 * Created by cong on 2019-01-03.
 */
public interface TeacherService {

    /**
     * 登录
     * 首次登录需要添加用户
     * @param wechatId
     * @param wechatIconUrl
     * @return
     */
    public ResponseVO login(String wechatId, String wechatIconUrl);

    /**
     * 根据微信号获取教师信息
     * @param wechatId
     * @return
     */
    public ResponseVO getTeacher(String wechatId);

    /**
     * 更新教师信息
     * @param
     * @return
     */
    public ResponseVO updateStudent(TeacherVO teacherVO);

}
