package cn.edu.nju.controller;

import cn.edu.nju.service.TopService;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopController {

    @Autowired
    private TopService topService;

    /**
     * 获取热度前十的教授
     * @return
     */
    @RequestMapping(value = "/top/professor",method = RequestMethod.GET)
    public ResponseVO getTopProfessors(){
        return topService.getTopProfessors();
    }

    /**
     * 获取热度前十的学校
     * @return
     */
    @RequestMapping(value = "/top/institude",method = RequestMethod.GET)
    public ResponseVO getTopInstitude(){
        return topService.getTopInstitude();
    }


}
