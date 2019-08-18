package cn.edu.nju.service;

import cn.edu.nju.constant.OrderStatusConstant;
import cn.edu.nju.mapper.OrderMapper;
import cn.edu.nju.vo.OrderModifyVO;
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

        // 如果该用户已预约过同一个服务
        // 且订单状态未完成，则不允许预约
        List<OrderVO> orderVOList = orderMapper.getOrderListByUserIdAndServiceId(userId, serviceId);
        for(OrderVO vo: orderVOList){
            if(vo.getStudentStatus() == OrderStatusConstant.NOT_FINISH ||
                    vo.getTeacherStatus() == OrderStatusConstant.NOT_FINISH){
                return ResponseVO.buildFailure("订单状态未完成，不能预约");
            }
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

    @Override
    public ResponseVO getAllOrder() {
        List<OrderVO> orderVOList = orderMapper.getAllOrder();
        return ResponseVO.buildSuccess(orderVOList);
    }

    @Override
    public ResponseVO deleteOrder(Integer orderId) {
        orderMapper.deleteOrderById(orderId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO modifyOrder(OrderModifyVO orderVO) {
        Integer orderId = orderVO.getId();
        if(null == orderId){
            return ResponseVO.buildFailure("订单Id为空");
        }

        int count = orderMapper.updateOrder(orderVO);
        if(count == 1){
            return ResponseVO.buildSuccess("修改成功");
        }else {
            return ResponseVO.buildFailure("未修改成功");
        }
    }

    @Override
    public ResponseVO modifyOrderStudentStatus(String orderId, int orderStatus) {
        int cnt = orderMapper.updateOrderStudentStatus(orderId, orderStatus);
        return cnt == 1 ? ResponseVO.buildSuccess("修改成功"): ResponseVO.buildFailure("修改失败");
    }

    @Override
    public ResponseVO modifyOrderTeacherStatus(String orderId, int orderStatus) {
        int cnt = orderMapper.updateOrderTeacherStatus(orderId, orderStatus);
        return cnt == 1 ? ResponseVO.buildSuccess("修改成功"): ResponseVO.buildFailure("修改失败");
    }
}
