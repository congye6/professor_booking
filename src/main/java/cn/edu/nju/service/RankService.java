package cn.edu.nju.service;

import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * x学校排名管理
 * Created by cong on 2019-01-01.
 */
public interface RankService {

    /**
     * 根据学校查询排名
     * @param institude
     * @return
     */
    public ResponseVO getRank(String institude);

    /**
     * 获取所有排名
     * @return
     */
    public ResponseVO getAllRank();

    /**
     * 添加排名
     * @param rankVO
     * @return
     */
    public ResponseVO insertRank(RankVO rankVO);

    /**
     * 更新排名
     * @param rankVO
     * @return
     */
    public ResponseVO updateRank(RankVO rankVO);
}
