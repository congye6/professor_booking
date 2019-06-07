package cn.edu.nju.service;

import cn.edu.nju.vo.MajorRankVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * 专业排名
 * Created by cong on 2019-01-01.
 */
public interface MajorRankService {

    /**
     * 查询学校的所有排名
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
    public ResponseVO insertRank(MajorRankVO rankVO);

    /**
     * 更新排名
     * @param rankVO
     * @return
     */
    public ResponseVO updateRank(MajorRankVO rankVO);

    /**
     * 删除排名
     * @param rankVO
     * @return
     */
    public ResponseVO deleteRank(MajorRankVO rankVO);


}
