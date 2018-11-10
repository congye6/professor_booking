package cn.edu.nju.controller;

import cn.edu.nju.service.AuditService;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cong on 2018-11-10.
 */
@RestController
public class AuditController {

    @Autowired
    private AuditService auditService;

    @RequestMapping(value = "/audit/all",method = RequestMethod.GET)
    public ResponseVO getAuditProfessors(){
        return auditService.getAuditProfessors();
    }

    @RequestMapping(value = "/audit/add/{wechatId}",method = RequestMethod.POST)
    public ResponseVO apply(@PathVariable String wechatId){
        return auditService.apply(wechatId);
    }

    @RequestMapping(value = "/audit/aprrove/{wechatId}",method = RequestMethod.POST)
    public ResponseVO audit(@PathVariable String wechatId){
        return auditService.audit(wechatId);
    }

}
