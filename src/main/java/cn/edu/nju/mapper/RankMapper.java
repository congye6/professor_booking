package cn.edu.nju.mapper;

import cn.edu.nju.vo.RankVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankMapper {

    int insert(RankVO record);

    RankVO selectByPrimaryKey(Integer id);

    RankVO selectByInstitude(String name);

    List<RankVO> selectAll();

    int updateByPrimaryKeySelective(RankVO record);
}