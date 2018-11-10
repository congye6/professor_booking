package cn.edu.nju.service;

import cn.edu.nju.enumeration.UserType;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by cong on 2018-11-10.
 */
@Service
public class AuditServiceImpl implements AuditService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO getAuditProfessors() {
        List<UserVO> auditProfessors=userMapper.selectUserByType(UserType.PROFESSOR_AUDIT);
        if(CollectionUtils.isEmpty(auditProfessors))
            return ResponseVO.buildFailure("暂无可审核专家");
        return ResponseVO.buildSuccess(auditProfessors);
    }

    @Override
    public ResponseVO apply(String wechatId) {
        UserVO userVO=userMapper.selectUser(wechatId);
        if(userVO==null)
            return ResponseVO.buildFailure("用户："+wechatId+"不存在");
        if(userVO.getUserType()!=UserType.STUDENT)
            return ResponseVO.buildFailure("用户状态不正确");
        userMapper.updateType(wechatId,UserType.PROFESSOR_AUDIT);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO audit(String wechatId) {
        UserVO userVO=userMapper.selectUser(wechatId);
        if(userVO==null)
            return ResponseVO.buildFailure("用户："+wechatId+"不存在");
        if(userVO.getUserType()!=UserType.PROFESSOR_AUDIT)
            return ResponseVO.buildFailure("用户状态不正确");
        userMapper.updateType(wechatId,UserType.PROFESSOR);
        return ResponseVO.buildSuccess();
    }
}
