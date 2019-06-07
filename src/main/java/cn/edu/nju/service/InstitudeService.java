package cn.edu.nju.service;

import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * x学校排名管理
 * Created by cong on 2019-01-01.
 */
public interface InstitudeService {

    /**
     * 根据学校查询排名
     * @param institude
     * @return
     */
    public ResponseVO getInstitude(String institude);

    /**
     * 获取所有排名
     * @return
     */
    public ResponseVO getAllInstitude();

    /**
     * 添加排名
     * @param institudeVO
     * @return
     */
    public ResponseVO insertInstitude(InstitudeVO institudeVO);

    /**
     * 更新排名
     * @param institudeVO
     * @return
     */
    public ResponseVO updateInstitude(InstitudeVO institudeVO);

    /**
     * 删除排名
     * @param name
     * @return
     */
    public ResponseVO deleteInstitude(String name);
}
