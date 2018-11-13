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
     */
    void insertService(@Param("professorId") Integer professorId, @Param("title") String title, @Param("content")String content,
                       @Param("reserveAddress") String reserveAddress, @Param("reserveTime") Timestamp reserveTime, @Param("deadline") Timestamp deadline,
                       @Param("serviceTypeId")int serviceTypeId, @Param("majorTypeId")int majorTypeId);

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
}
