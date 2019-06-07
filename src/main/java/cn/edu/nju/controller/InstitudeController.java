package cn.edu.nju.controller;

import cn.edu.nju.service.InstitudeService;
import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学校信息
 * 包含排名，图标，国家
 * Created by cong on 2019-01-01.
 */
@RestController
public class InstitudeController {

    @Autowired
    private InstitudeService institudeService;

    /**
     * 根据学校查询排名
     * @param institude
     * @return
     */
    @RequestMapping(value = "/rank/institude/name/{institude}",method = RequestMethod.GET)
    public ResponseVO getInstitude(@PathVariable String institude){
        return institudeService.getInstitude(institude);
    }

    /**
     * 获取所有排名
     * @return
     */
    @RequestMapping(value = "/rank/institude/all",method = RequestMethod.GET)
    public ResponseVO getAllInstitude(){
        return institudeService.getAllInstitude();
    }

    /**
     * 添加排名
     * @param institudeVO
     * @return
     */
    @RequestMapping(value = "/rank/institude",method = RequestMethod.POST)
    public ResponseVO insertInstitude(@RequestBody InstitudeVO institudeVO){
        return institudeService.insertInstitude(institudeVO);
    }

    /**
     * 更新排名
     * @param institudeVO
     * @return
     */
    @RequestMapping(value = "/rank/institude/update",method = RequestMethod.POST)
    public ResponseVO updateInstitude(@RequestBody InstitudeVO institudeVO){
        return institudeService.updateInstitude(institudeVO);
    }

    /**
     * 删除排名
     * @param name
     * @return
     */
    @RequestMapping(value = "/rank/institude/delete/{name}",method = RequestMethod.POST)
    public ResponseVO deleteInstitude(@PathVariable String name){
        return institudeService.deleteInstitude(name);
    }
}
