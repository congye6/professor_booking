package cn.edu.nju.controller;

import cn.edu.nju.service.MajorRankService;
import cn.edu.nju.vo.MajorRankVO;
import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-01.
 */
@RestController
public class MajorRankController {

    @Autowired
    private MajorRankService majorRankService;

    /**
     * 获取学校所有排名
     * @param
     * @return
     */
    @RequestMapping(value = "/rank/major/name/{major}",method = RequestMethod.GET)
    public ResponseVO getRank(@PathVariable String major){
        return majorRankService.getRank(major);
    }

    /**
     * 获取所有排名
     * @return
     */
    @RequestMapping(value = "/rank/major/all",method = RequestMethod.GET)
    public ResponseVO getAllRank(){
        return majorRankService.getAllRank();
    }

    /**
     * 添加排名
     * @param rankVO
     * @return
     */
    @RequestMapping(value = "/rank/major",method = RequestMethod.POST)
    public ResponseVO insertRank(@RequestBody MajorRankVO rankVO){
        return majorRankService.insertRank(rankVO);
    }

    /**
     * 更新排名
     * @param rankVO
     * @return
     */
    @RequestMapping(value = "/rank/major/update",method = RequestMethod.POST)
    public ResponseVO updateRank(@RequestBody MajorRankVO rankVO){
        return majorRankService.updateRank(rankVO);
    }

    @RequestMapping(value = "/rank/major/delete",method = RequestMethod.POST)
    public ResponseVO deleteRank(@RequestBody MajorRankVO rankVO){
        return majorRankService.deleteRank(rankVO);
    }
}
