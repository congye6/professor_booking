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

    private static final String PROFESSOR_APPID = "wxfca5789ab8e907d9";
    private static final String PROFESSOR_SECRET = "6d998869c40d4463d924e3ef02318e47";

    private static final String STUDENT_APPID = "wx3104bba58c0a9ed2";
    private static final String STUDENT_SECRET = "86869b2a124880e5fa2f80680d2f2fa3";

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
