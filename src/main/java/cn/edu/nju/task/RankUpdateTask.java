package cn.edu.nju.task;


import cn.edu.nju.mapper.MajorRankMapper;
import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.util.ExcelUtil;
import cn.edu.nju.vo.MajorRankVO;
import cn.edu.nju.vo.RankVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RankUpdateTask {

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private RankMapper rankMapper;

    @Autowired
    private MajorRankMapper majorRankMapper;

    @Transactional
    public void updateInstitude(String filePath){
        List<RankVO> list=excelUtil.readRankToJson(filePath, RankVO.class);
        for(RankVO rankVO:list){
            try{
                rankMapper.updateByInstitude(rankVO);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Transactional
    public void insertMajorRank(String filePath){
        List<MajorRankVO> list=excelUtil.readMajorRank(filePath);
        for(MajorRankVO rankVO:list){
                majorRankMapper.insert(rankVO);
        }
    }


}
