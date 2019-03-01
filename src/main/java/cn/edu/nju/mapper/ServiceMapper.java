package cn.edu.nju.mapper;

import cn.edu.nju.vo.ServiceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/10
 */
@Mapper
public interface ServiceMapper {

    /**
     * 新增服务记录
     * @param professorId
     * @param title
     * @param content
     * @param reserveAddress
     * @param reserveTime
     * @param deadline
     * @param serviceTypeId
     * @param majorTypeId
     * @param
     */
    void insertService(@Param("professorId") Integer professorId, @Param("title") String title, @Param("content")String content,
                       @Param("reserveAddress") String reserveAddress, @Param("reserveTime") Timestamp reserveTime,
                       @Param("deadline") Timestamp deadline, @Param("serviceTypeId")int serviceTypeId,
                       @Param("majorTypeId")int majorTypeId, @Param("price")int price);

    /**
     * 删除服务
     * @param serviceId
     */
    void deleteService(int serviceId);

    /**
     * 获取服务列表
     * @param startPos
     * @param num
     * @return
     */
    List<ServiceVO> getServiceList(@Param("startPos") int startPos, @Param("num") int num);

    /**
     * 根据服务Id获取服务信息
     * @param serviceId
     * @return
     */
    ServiceVO getServiceById(@Param("serviceId") int serviceId);

    /**
     * 通过专家id获取服务列表
     * @param expertId 专家id
     * @return
     */
    List<ServiceVO> getServiceListByExpertId(@Param("expertId")int expertId);

    /**
     * 修改服务
     * @param serviceVO
     * @return
     */
    int updateService(ServiceVO serviceVO);

    /**
     * 通过对服务标题的模糊匹配获取服务
     * @param title
     * @return
     */
    List<ServiceVO> getServiceListByTitle(@Param("title") String title);

    /**
     * 通过对服务正文的模糊匹配获取服务
     * @param content
     * @return
     */
    List<ServiceVO> getServiceListByContent(@Param("content") String content);

    /**
     * 获取服务数量
     * @return
     */
    int getCount();
}
