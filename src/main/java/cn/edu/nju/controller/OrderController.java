package cn.edu.nju.controller;

import cn.edu.nju.service.OrderService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getReserveList(@RequestParam("userId") Integer userId){
        return orderService.getOrderList(userId);
    }

}
