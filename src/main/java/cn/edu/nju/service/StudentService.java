package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;

/**
 * 学生用户管理
 * Created by cong on 2019-01-02.
 */
public interface StudentService {

    /**
     * 登录
     * 首次登录需要添加用户
     * @param wechatId
     * @param wechatIconUrl
     * @return
     */
    public ResponseVO login(String wechatId,String wechatIconUrl);

    /**
     * 根据微信号获取学生信息
     * @param wechatId
     * @return
     */
    public ResponseVO getStudent(String wechatId);

    /**
     * 更新学生信息
     * @param studentVO
     * @return
     */
    public ResponseVO updateStudent(StudentVO studentVO);

}
