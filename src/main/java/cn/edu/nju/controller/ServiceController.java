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

    @RequestMapping(value = "/professor/{professorName}", method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable String professorName){
        return serviceService.serviceSearchByProfessorName(professorName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseVO createService(@RequestBody ServiceVO serviceCreateVO){
        return serviceService.serviceCreate(serviceCreateVO);
    }



}
