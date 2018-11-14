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
    public ResponseVO getUser(int id) {
        UserVO userVO=userMapper.selectUserById(id);
        return ResponseVO.buildSuccess(userVO);
    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        UserVO userInDb=userMapper.selectUserById(userVO.getId());
        if(userInDb==null)
            return ResponseVO.buildFailure("用户不存在");
        userMapper.updateSelective(userVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteUser(int id) {
        userMapper.delete(id);
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
