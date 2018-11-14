package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;

/**
 * Created by cong on 2018-11-07.
 */
public interface UserService {

    /**
     * 根据微信id获取用户信息
     * @param wechatId
     * @return
     */
    public ResponseVO getUser(int id);

    /**
     * 修改用户信息
     * @param userVO
     * @return
     */
    public ResponseVO updateUser(UserVO userVO);

    /**
     * 删除用户
     * @param wechatId
     * @return
     */
    public ResponseVO deleteUser(int id);

    /**
     * 根据姓名模糊搜索
     * @param name
     * @return
     */
    public ResponseVO searchUserByName(String name);

    public ResponseVO searchUserBySchool(String school);

    public ResponseVO searchUserByInterest(String interest);

}
