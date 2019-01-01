package cn.edu.nju.controller;

import cn.edu.nju.service.RankService;
import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-01.
 */
@RestController
public class RankController {

    @Autowired
    private RankService rankService;

    /**
     * 根据学校查询排名
     * @param institude
     * @return
     */
    @RequestMapping(value = "/rank/institude/name/{institude}",method = RequestMethod.GET)
    public ResponseVO getRank(@PathVariable String institude){
        return rankService.getRank(institude);
    }

    /**
     * 获取所有排名
     * @return
     */
    @RequestMapping(value = "/rank/institude/all",method = RequestMethod.GET)
    public ResponseVO getAllRank(){
        return rankService.getAllRank();
    }

    /**
     * 添加排名
     * @param rankVO
     * @return
     */
    @RequestMapping(value = "/rank/institude",method = RequestMethod.POST)
    public ResponseVO insertRank(@RequestBody RankVO rankVO){
        return rankService.insertRank(rankVO);
    }

    /**
     * 更新排名
     * @param rankVO
     * @return
     */
    @RequestMapping(value = "/rank/institude/update",method = RequestMethod.POST)
    public ResponseVO updateRank(@RequestBody RankVO rankVO){
        return rankService.updateRank(rankVO);
    }

}
