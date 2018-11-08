package cn.edu.nju.service;

import cn.edu.nju.enumeration.UserType;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by cong on 2018-11-07.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    public ResponseVO register(UserVO userVO){
        if(StringUtils.isEmpty(userVO.getWechatId()))
            return ResponseVO.buildFailure("微信id不能为空");
        UserVO userInDb=userMapper.selectUser(userVO.getWechatId());
        if(userInDb!=null)
            return ResponseVO.buildFailure("用户已注册");

        //刚开始权限为学生
        userVO.setUserType(UserType.STUDENT);

        userMapper.insertSelective(userVO);
        return ResponseVO.buildSuccess();
    }

}
