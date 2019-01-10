package cn.edu.nju.controller;

import cn.edu.nju.service.StudentService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2019-01-02.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/student/login",method = RequestMethod.GET)
    public ResponseVO login(@RequestParam("wid") String wechatId,
                            @RequestParam("avatar") String wechatIconUrl){
        return studentService.login(wechatId,wechatIconUrl);

    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ResponseVO getStudent(@RequestParam("wid") String wechatId){
        return studentService.getStudent(wechatId);
    }

    @RequestMapping(value = "/student/update",method = RequestMethod.GET)
    public ResponseVO updateStudent(@RequestParam("wid") String wechatId,@RequestParam("name")String name,
                                    @RequestParam("phone")String phone,@RequestParam("company") String company,
                                    @RequestParam("email") String email){
        StudentVO studentVO=new StudentVO();
        studentVO.setWechatId(wechatId);
        studentVO.setCompany(company);
        studentVO.setEmail(email);
        studentVO.setName(name);
        studentVO.setPhone(phone);
        return studentService.updateStudent(studentVO);
    }

    @RequestMapping(value = "/student/orders",method = RequestMethod.GET)
    public ResponseVO getOrders(@RequestParam("wid") String wechatId){
        return studentService.getOrders(wechatId);
    }

}
