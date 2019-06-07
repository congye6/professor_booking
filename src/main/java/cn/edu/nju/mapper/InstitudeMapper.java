package cn.edu.nju.mapper;

import cn.edu.nju.vo.InstitudeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstitudeMapper {

    int insert(InstitudeVO record);

    InstitudeVO selectByPrimaryKey(Integer id);

    InstitudeVO selectByInstitude(String name);

    List<InstitudeVO> selectAll();

    int updateByInstitude(InstitudeVO record);

    void deleteByInstitude(String name);
}