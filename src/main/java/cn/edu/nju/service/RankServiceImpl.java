package cn.edu.nju.service;

import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-01.
 */
@Service
public class RankServiceImpl implements RankService{

    @Autowired
    private RankMapper rankMapper;

    @Override
    public ResponseVO getRank(String institude) {
        return ResponseVO.buildSuccess(rankMapper.selectByInstitude(institude));
    }

    @Override
    public ResponseVO getAllRank() {
        return ResponseVO.buildSuccess(rankMapper.selectAll());
    }

    @Override
    public ResponseVO insertRank(RankVO rankVO) {
        RankVO rankInDb=rankMapper.selectByInstitude(rankVO.getInstitude());
        if(rankInDb!=null)
            return ResponseVO.buildFailure(rankVO.getInstitude()+"排名已存在");
        rankMapper.insert(rankVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateRank(RankVO rankVO) {
        rankMapper.updateByInstitude(rankVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteRank(String name) {
        rankMapper.deleteByInstitude(name);
        return ResponseVO.buildSuccess();
    }
}
