package cn.edu.nju.mapper;

import cn.edu.nju.vo.MajorTypeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/13
 */

@Mapper
public interface MajorTypeMapper {

    /**
     * 获取所有专业分类
     * @return
     */
    List<MajorTypeVO> getAllMajorType();

}
