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
     * 获取所有预约
     * @return
     */
    ResponseVO getAllOrder();

    /**
     * 根据教授状态获取所有预约
     * @param professorId 教授id
     * @param orderStatus 教授状态
     * @return
     */
    ResponseVO getOrderByTeacherStatus(String professorId, int orderStatus);

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

    /**
     * 将预约表中学生状态字段设置
     * @param orderId 订单Id
     * @param orderStatus 订单状态
     * @return
     */
    ResponseVO modifyOrderStudentStatus(String orderId, int orderStatus);

    /**
     * 将预约表中教授状态字段设置
     * @param orderId 订单Id
     * @param orderStatus 订单状态
     * @return
     */
    ResponseVO modifyOrderTeacherStatus(String orderId, int orderStatus);
}
