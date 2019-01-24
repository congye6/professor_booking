package cn.edu.nju.controller;

import cn.edu.nju.service.StudentService;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.StudentVO;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 分页获取学生信息
     * @param page      第几页，从0开始
     * @param pageSize  一页有多少条
     * @return
     */
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ResponseVO getStudents(@RequestParam int page,@RequestParam int pageSize){
        return studentService.getStudents(page,pageSize);
    }

    /**
     * 获取所有学生数量
     * @return
     */
    @RequestMapping(value = "/student/count",method = RequestMethod.GET)
    public ResponseVO getCount(){
        return studentService.getCount();
    }

    /**
     * 获取所有未审核学生
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/students/audit",method = RequestMethod.GET)
    public ResponseVO getToAuditStudents(@RequestParam int page,@RequestParam int pageSize){
        return studentService.getToAuditStudents(page,pageSize);
    }

    /**
     * 获取所有未审核的数量
     * @return
     */
    @RequestMapping(value = "/student/audit/count",method = RequestMethod.GET)
    public ResponseVO getAuditCount(){
        return studentService.getAuditCount();
    }

    /**
     * 学生审核成功
     * @param wechatId
     * @return
     */
    @RequestMapping(value = "/student/audit/{wechatId}",method = RequestMethod.POST)
    public ResponseVO audit(@PathVariable String wechatId){
        return studentService.audit(wechatId);
    }
}
