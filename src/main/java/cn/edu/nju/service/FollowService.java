package cn.edu.nju.service;

import cn.edu.nju.vo.FollowVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * 关注
 * Created by cong on 2019-01-25.
 */
public interface FollowService {

    /**
     * 关注教师
     * @param followVO
     * @return
     */
    public ResponseVO follow(FollowVO followVO);

    /**
     * 取消关注
     * @param followVO
     * @return
     */
    public ResponseVO unfollow(FollowVO followVO);

    /**
     * 我的关注
     * @param studentWechatId
     * @return
     */
    public ResponseVO followees(String studentWechatId);

    /**
     * 关注我的
     * @param teacherInfoId
     * @return
     */
    public ResponseVO followers(Integer teacherInfoId);


}
