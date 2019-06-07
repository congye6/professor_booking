package cn.edu.nju.task;


import cn.edu.nju.mapper.MajorRankMapper;
import cn.edu.nju.mapper.InstitudeMapper;
import cn.edu.nju.util.ExcelUtil;
import cn.edu.nju.vo.MajorRankVO;
import cn.edu.nju.vo.InstitudeVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RankUpdateTask {

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private InstitudeMapper institudeMapper;

    @Autowired
    private MajorRankMapper majorRankMapper;

    @Transactional
    public void updateInstitude(String filePath){
        List<InstitudeVO> list=excelUtil.readXlsToJson(filePath, InstitudeVO.class);
        for(InstitudeVO institudeVO :list){
            try{
                System.out.println(JSONObject.toJSONString(institudeVO));
                institudeMapper.insert(institudeVO);
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
