package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;

import java.util.List;

/**
 * 教授审核管理
 * Created by cong on 2018-11-08.
 */
public interface AuditService {

    /**
     * 获取所有待审核的专家
     * @return
     */
    public ResponseVO getAuditProfessors();

    /**
     * 申请成为专家
     * @return
     */
    public ResponseVO apply(String wechatId);

    /**
     * 审核教授
     * @param wechatId
     * @return
     */
    public ResponseVO audit(String wechatId);




}
