package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import cn.edu.nju.vo.TeacherDetailVO;
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
    public TeacherDetailVO getTeacher(String wechatId);

    /**
     * 分页获取教师信息
     * @param page      第几页，从0开始
     * @param pageSize  一页有多少条
     * @return
     */
    public ResponseVO getTeachers(int page,int pageSize);

    /**
     * 一共有多少教师用户
     * @return
     */
    public ResponseVO getCount();

    /**
     * 更新教师信息
     * @param
     * @return
     */
    public ResponseVO updateTeacher(TeacherVO teacherVO);

    /**
     * 获取我的预约
     * @param wechatId
     * @return
     */
    public ResponseVO getOrders(String wechatId);

    /**
     * 根据wechat昵称模糊查找
     * @param wechatName
     * @return
     */
    public ResponseVO searchUserByWechatName(String wechatName);

    /**
     * 根据微信id删除教师用户
     * @param wechatId
     * @return
     */
    public ResponseVO deleteByWechatId(String wechatId);

}
