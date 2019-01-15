package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;

/**
 * Created by cong on 2018-11-07.
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * @param wechatId
     * @return
     */
    public ResponseVO getUser(int id);

    /**
     * 分页获取用户数据
     * @param pageIndex 获取第几页的数据，从0开始
     * @param pageSize  一页有多少条数据
     * @return
     */
    public ResponseVO getUserByPage(int pageIndex,int pageSize);

    /**
     * 获取用户总数
     * @return
     */
    public ResponseVO getUserCount();

    /**
     * 修改用户信息
     * @param userVO
     * @return
     */
    public ResponseVO updateUser(UserVO userVO);

    /**
     * 获取所有的国家
     * @return
     */
    public ResponseVO getAllCountry();

    /**
     * 获取所有的职称
     * @return
     */
    public ResponseVO getAllPosition();

    /**
     * 删除用户
     * @param wechatId
     * @return
     */
    public ResponseVO deleteUser(int id);

    /**
     * 添加用户
     * @param userVO
     * @return
     */
    public ResponseVO addUser(UserVO userVO);

}
