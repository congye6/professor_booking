package cn.edu.nju.service;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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
    public ResponseVO getUserByPage(int pageIndex, int pageSize) {
        if(pageIndex<0||pageSize<1)
            return ResponseVO.buildFailure("参数错误");
        List<UserVO> professors=userMapper.selectUser(pageIndex*pageSize,pageSize);
        return ResponseVO.buildSuccess(professors);
    }

    @Override
    public ResponseVO getUserCount() {
        return ResponseVO.buildSuccess(userMapper.selectCount());
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
    public ResponseVO getAllCountry() {
        return ResponseVO.buildSuccess(userMapper.selectCountry());
    }

    @Override
    public ResponseVO getAllPosition() {
        return ResponseVO.buildSuccess(userMapper.selectPosition());
    }

    @Override
    public ResponseVO deleteUser(int id) {
        userMapper.delete(id);
        return ResponseVO.buildSuccess();
    }

}
