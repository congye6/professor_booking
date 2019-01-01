package cn.edu.nju.mapper;

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
     * @param userId
     * @param serviceId
     * @return
     */
    void saveOrder(@Param("userId")int userId, @Param("serviceId")int serviceId);

    /**
     * 获取我的预约列表
     * @param userId
     * @return
     */
    List<OrderVO> getOrderList(@Param("userId")int userId);

}