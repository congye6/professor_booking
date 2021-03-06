package cn.edu.nju.controller;

import cn.edu.nju.constant.OrderStatusConstant;
import cn.edu.nju.service.OrderService;
import cn.edu.nju.vo.OrderModifyVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
@RestController
@RequestMapping("/reserve")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseVO createReserve(@RequestParam("userId") Integer userId,
                                    @RequestParam("serviceId")Integer serviceId){
        return orderService.saveOrder(userId, serviceId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseVO deleteReserve(@RequestParam("orderId") Integer orderId){
        return orderService.deleteOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseVO modifyReserve(@RequestBody OrderModifyVO orderVO){
        return orderService.modifyOrder(orderVO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getReserveList(@RequestParam("userId") Integer userId){
        return orderService.getOrderList(userId);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseVO getAllReserveList(){
        return orderService.getAllOrder();
    }

    @RequestMapping(value = "/student/finish", method = RequestMethod.GET)
    public ResponseVO modifyOrderStatusByStudent(@RequestParam("orderId")String orderId){
        return orderService.modifyOrderStudentStatus(orderId, OrderStatusConstant.FINISHED);
    }

    @RequestMapping(value = "/teacher/finish", method = RequestMethod.GET)
    public ResponseVO modifyOrderStatusByTeacher(@RequestParam("orderId")String orderId){
        return orderService.modifyOrderTeacherStatus(orderId, OrderStatusConstant.FINISHED);
    }

    @RequestMapping(value = "/teacher/delete", method = RequestMethod.GET)
    public ResponseVO setOrderStatusDeleted(@RequestParam("orderId")String orderId){
        return orderService.modifyOrderTeacherStatus(orderId, OrderStatusConstant.DELETED);
    }

    @RequestMapping(value = "/teacher/getFinished", method = RequestMethod.GET)
    public ResponseVO getAllFinishedOrder(@RequestParam("professorId")String professorId){
        return orderService.getOrderByTeacherStatus(professorId, OrderStatusConstant.FINISHED);
    }

}
