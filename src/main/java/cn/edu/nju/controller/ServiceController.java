package cn.edu.nju.controller;

import cn.edu.nju.vo.ServiceVO;
import cn.edu.nju.service.ServiceService;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/09
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseVO createService(@RequestBody ServiceVO serviceCreateVO){
        return serviceService.serviceCreate(serviceCreateVO);
    }

    @RequestMapping(value = "/search/{content}", method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable String content){
        return serviceService.serviceSearch(content);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO getServiceList(@RequestParam("startPos")int startPos,
                                 @RequestParam("number")int number){
        return serviceService.serviceList(startPos, number);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseVO getServiceDetail(@RequestParam("serviceId")int serviceId){
        return serviceService.serviceDetail(serviceId);
    }

    @RequestMapping(value = "/major_type", method = RequestMethod.GET)
    public ResponseVO getAllMajorType(){
        return serviceService.getAllMajorType();
    }

    @RequestMapping(value = "/service_type", method = RequestMethod.GET)
    public ResponseVO getAllServiceType(){
        return serviceService.getAllServiceType();
    }


}
