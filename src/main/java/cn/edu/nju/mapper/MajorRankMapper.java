package cn.edu.nju.mapper;

import cn.edu.nju.vo.MajorRankVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 专业排名
 */
@Mapper
public interface MajorRankMapper {

    int insert(MajorRankVO record);

    int update(MajorRankVO record);

    List<MajorRankVO> selectAll();

    Integer selectRank(@Param("institude") String institude,@Param("major") String major);

    List<MajorRankVO> selectByInstitude(String institude);
}