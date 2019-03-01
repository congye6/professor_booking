package cn.edu.nju.service;

import cn.edu.nju.vo.OrderModifyVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
public interface OrderService {

    /**
     * 保存预约
     * @param userId 用户id
     * @param serviceId 服务id
     * @return
     */
    ResponseVO saveOrder(Integer userId, Integer serviceId);

    /**
     * 获取我的预约
     * @param userId
     * @return
     */
    ResponseVO getOrderList(Integer userId);

    /**
     * 删除订单id
     * @param orderId
     * @return
     */
    ResponseVO deleteOrder(Integer orderId);

    /**
     * 修改订单
     * @param orderVO
     * @return
     */
    ResponseVO modifyOrder(OrderModifyVO orderVO);
}
