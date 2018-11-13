package cn.edu.nju.mapper;

import cn.edu.nju.vo.ServiceTypeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */
@Mapper
public interface ServiceTypeMapper {

    /**
     * 获取所有服务分类
     * @return
     */
    List<ServiceTypeVO> getAllServiceType();
}
