package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;

/**
 * Created by cong on 2018-11-07.
 */
public interface LoginService {

    /**
     * 用户注册
     * TODO 注册流程
     * @param userVO
     * @return
     */
    public ResponseVO register(UserVO userVO);

}
