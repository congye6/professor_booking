package cn.edu.nju.controller;

import cn.edu.nju.service.WeChatService;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/10
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    private static final String PROFESSOR_APPID = "wxf0c8176f6d092d15";
    private static final String PROFESSOR_SECRET = "cb36a0b19e7512b9c31c72f583b799a2";

    private static final String STUDENT_APPID = "wxa9de6d401acaf60a";
    private static final String STUDENT_SECRET = "0964e68df87b345105f7ac6d03b03019";

    private WeChatService weChatService;

    public WeChatController(WeChatService weChatService) {
        this.weChatService = weChatService;
    }

    @RequestMapping(value = "/professor", method = RequestMethod.GET)
    public ResponseVO professor(@RequestParam("resCode")String resCode){
        return weChatService.getWeChatKey(PROFESSOR_APPID, PROFESSOR_SECRET, resCode);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseVO student(@RequestParam("resCode")String resCode){
        return weChatService.getWeChatKey(STUDENT_APPID, STUDENT_SECRET, resCode);
    }


}
