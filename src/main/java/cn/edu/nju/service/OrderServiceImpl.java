package cn.edu.nju.service;

import cn.edu.nju.mapper.OrderMapper;
import cn.edu.nju.vo.OrderVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
@Service
public class OrderServiceImpl implements OrderService{

    private OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public ResponseVO saveOrder(Integer userId, Integer serviceId) {
        if(userId == null || serviceId == null){
            return ResponseVO.buildFailure("预约信息不完整");
        }
        orderMapper.saveOrder(userId, serviceId);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO getOrderList(Integer userId) {
        if(userId == null){
            return ResponseVO.buildFailure("用户名为空");
        }

        List<OrderVO> orderVOList = orderMapper.getOrderList(userId);
        return ResponseVO.buildSuccess(orderVOList);
    }
}
