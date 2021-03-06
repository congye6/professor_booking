package cn.edu.nju.controller;

import cn.edu.nju.service.ServiceService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.ServiceVO;
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

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseVO deleteService(@RequestParam Integer serviceId){
        return serviceService.deleteService(serviceId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseVO modifyService(@RequestBody ServiceVO serviceVO){
        return serviceService.modifyService(serviceVO);
    }

    @RequestMapping(value = "/search/expert", method = RequestMethod.GET)
    public ResponseVO searchExpert(@RequestParam("expert")String expert, @RequestParam("nation")String nation,
                                   @RequestParam("position")String position, @RequestParam("major")String major,
                                   @RequestParam("startPos")Integer startPos, @RequestParam("number")Integer number,
                                   @RequestParam("orderBy")String orderBy){
        return serviceService.expertSearch(expert, nation, position, major, startPos, number, orderBy);
    }

    @RequestMapping(value = "/search/service", method = RequestMethod.GET)
    public ResponseVO searchService(@RequestParam("serviceName")String serviceName,
                                    @RequestParam("nation")String nation, @RequestParam("position")String position,
                                    @RequestParam("school")String school, @RequestParam("serviceType")Integer serviceType,
                                    @RequestParam("majorType")Integer majorType, @RequestParam("startPos")Integer startPos,
                                    @RequestParam("number")Integer number){
        return serviceService.serviceSearch(serviceName, nation, position, school, serviceType,
                majorType, startPos, number);
    }

    @RequestMapping(value = "/expert", method = RequestMethod.GET)
    public ResponseVO getExpertServiceInfo(@RequestParam("expertId")Integer expertId){
        return serviceService.getServiceByExpertId(expertId);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseVO getServiceDetail(@RequestParam("serviceId")Integer serviceId){
        return serviceService.serviceDetail(serviceId);
    }

    @RequestMapping(value = "/service_type", method = RequestMethod.GET)
    public ResponseVO getAllServiceType(){
        return serviceService.getAllServiceType();
    }

    @RequestMapping(value = "/major_type", method = RequestMethod.GET)
    public ResponseVO getAllMajorType(){
        return serviceService.getAllMajorType();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO getServiceList(@RequestParam("startPos")Integer startPos, @RequestParam("number")Integer number){
        return serviceService.serviceList(startPos, number);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseVO count(){
        return serviceService.getServiceCount();
    }


}
