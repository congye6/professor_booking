package cn.edu.nju.mapper;

import cn.edu.nju.vo.ServiceExpertVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/01
 */
@Mapper
public interface ServiceExpertMapper {

    /**
     * 根据条件搜索服务信息
     * @param serviceName 服务名
     * @param nation 国家
     * @param position 职位
     * @param school 学校
     * @param serviceType 服务类型
     * @param majorType 专业类型
     * @return
     */
    List<ServiceExpertVO> getSearchExpertInfo(@Param("serviceName") String serviceName, @Param("nation") String nation,
                                              @Param("position") String position, @Param("school") String school,
                                              @Param("serviceType") int serviceType, @Param("majorType") int majorType);

}
