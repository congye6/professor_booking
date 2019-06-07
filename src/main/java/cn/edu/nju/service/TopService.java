package cn.edu.nju.service;

import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;

import java.util.List;

/**
 * Top教师
 */
public interface TopService {

    /**
     * 获取热度前十的教授
     * @return
     */
    public ResponseVO getTopProfessors();

    /**
     * 获取热度前十的学校
     * @return
     */
    public ResponseVO getTopInstitude();

}
