package cn.edu.nju.service;

import cn.edu.nju.mapper.MajorRankMapper;
import cn.edu.nju.vo.MajorRankVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-01.
 */
@Service
public class MajorRankServiceImpl implements MajorRankService{

    @Autowired
    private MajorRankMapper majorRankMapper;

    @Override
    public ResponseVO getRank(String institude) {
        return ResponseVO.buildSuccess(majorRankMapper.selectByInstitude(institude));
    }

    @Override
    public ResponseVO getAllRank() {
        return ResponseVO.buildSuccess(majorRankMapper.selectAll());
    }

    @Override
    public ResponseVO insertRank(MajorRankVO rankVO) {
        Double rank=majorRankMapper.selectRank(rankVO.getInstitude(),rankVO.getMajor());
        if(rank!=null)
            return ResponseVO.buildFailure("该专业排名已存在");
        majorRankMapper.insert(rankVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateRank(MajorRankVO rankVO) {
        majorRankMapper.update(rankVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteRank(MajorRankVO rankVO) {
        majorRankMapper.delete(rankVO);
        return ResponseVO.buildSuccess();
    }
}
