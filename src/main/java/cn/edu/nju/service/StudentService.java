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


    /**
     * 获取我的预约列表
     * @param wechatId
     * @return
     */
    public ResponseVO getOrders(String wechatId);

    /**
     * 分页获取学生信息
     * @param page      第几页，从0开始
     * @param pageSize  一页有多少条
     * @return
     */
    public ResponseVO getStudents(int page,int pageSize);

    /**
     * 获取所有学生数量
     * @return
     */
    public ResponseVO getCount();

    /**
     * 获取所有未审核学生
     * @param page
     * @param pageSize
     * @return
     */
    public ResponseVO getToAuditStudents(int page,int pageSize);

    /**
     * 获取所有未审核的数量
     * @return
     */
    public ResponseVO getAuditCount();

    /**
     * 学生审核成功
     * @param wechatId
     * @return
     */
    public ResponseVO audit(String wechatId);

}
