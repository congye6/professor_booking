package cn.edu.nju.service;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by cong on 2018-11-08.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO getUser(String wechatId) {
        if(StringUtils.isEmpty(wechatId))
            return ResponseVO.buildFailure("微信id不能为空");
        UserVO userVO=userMapper.selectUser(wechatId);
        return ResponseVO.buildSuccess(userVO);
    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        UserVO userInDb=userMapper.selectUser(userVO.getWechatId());
        if(userInDb==null)
            return ResponseVO.buildFailure("用户不存在");
        userMapper.updateSelective(userVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteUser(String wechatId) {
        userMapper.delete(wechatId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO searchUserByName(String name) {
        return ResponseVO.buildSuccess(userMapper.selectUserByName(name));
    }

    @Override
    public ResponseVO searchUserBySchool(String school) {
        return ResponseVO.buildSuccess(userMapper.selectUserBySchool(school));
    }

    @Override
    public ResponseVO searchUserByInterest(String interest) {
        return ResponseVO.buildSuccess(userMapper.selectUserByInterest(interest));
    }
}
