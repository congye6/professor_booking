package cn.edu.nju.service;

import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.util.NameUtil;
import cn.edu.nju.vo.RankVO;
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

    @Autowired
    private RankMapper rankMapper;

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
        if(!StringUtils.isEmpty(userVO.getSchool())){//更新学校前检查排名
            RankVO rank=rankMapper.selectByInstitude(userVO.getSchool());
            if(rank==null)
                return ResponseVO.buildFailure("学校："+userVO.getSchool()+" 不存在,请先维护改学校排名");
            userVO.setInstitudeRank(rank.getRank());
        }

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

    @Override
    public ResponseVO addUser(UserVO userVO) {
        RankVO rank=rankMapper.selectByInstitude(userVO.getSchool());
        if(rank==null)
            return ResponseVO.buildFailure("学校："+userVO.getSchool()+" 不存在,请先维护改学校排名");
        userVO.setInstitudeRank(rank.getRank());

        if(StringUtils.isEmpty(userVO.getName()))
            return ResponseVO.buildFailure("姓名不能为空");
        NameUtil.processName(userVO);

        userMapper.insertSelective(userVO);
        return ResponseVO.buildSuccess();
    }

}
