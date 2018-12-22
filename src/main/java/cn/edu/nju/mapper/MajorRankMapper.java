package cn.edu.nju.mapper;

import cn.edu.nju.vo.MajorRankVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 专业排名
 */
@Mapper
public interface MajorRankMapper {

    int insert(MajorRankVO record);

    int updateByPrimaryKeySelective(MajorRankVO record);

    List<MajorRankVO> selectAll();

    List<MajorRankVO> selectByInstitude(String institude);
}