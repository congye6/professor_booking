package cn.edu.nju.mapper;

import cn.edu.nju.vo.OrderModifyVO;
import cn.edu.nju.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
@Mapper
public interface OrderMapper {

    /**
     * 保存预约
     * @param studentId
     * @param serviceId
     * @return
     */
    void saveOrder(@Param("studentId")int studentId, @Param("serviceId")int serviceId);

    /**
     * 根据用户和服务获取预约信息
     * @param userId
     * @param serviceId
     * @return
     */
    List<OrderVO> getOrderListByUserIdAndServiceId(@Param("userId")int userId, @Param("serviceId")int serviceId);

    /**
     * 获取我的预约列表
     * @param userId
     * @return
     */
    List<OrderVO> getOrderList(@Param("userId")int userId);

    /**
     * 获取所有预约信息
     * @return
     */
    List<OrderVO> getAllOrder();

    /**
     * 获取服务的所有订单
     * @param serviceId
     * @return
     */
    List<OrderVO> getOrderByService(int serviceId);

    /**
     * 删除订单id
     * @param orderId
     * @return
     */
    int deleteOrderById(int orderId);

    /**
     * 修改订单
     * @param orderVO
     * @return
     */
    int updateOrder(OrderModifyVO orderVO);

    /**
     * 更新订单学生状态
     * @param orderId 订单Id
     * @param orderStatus 订单状态
     * @return
     */
    int updateOrderStudentStatus(@Param("orderId") String orderId, @Param("orderStatus") int orderStatus);

    /**
     * 更新订单教授状态
     * @param orderId 订单Id
     * @param orderStatus 订单状态
     * @return
     */
    int updateOrderTeacherStatus(@Param("orderId") String orderId, @Param("orderStatus") int orderStatus);
}
