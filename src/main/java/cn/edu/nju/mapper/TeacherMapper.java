package cn.edu.nju.mapper;

import cn.edu.nju.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    List<TeacherVO> selectByName(String wechatName);

    List<TeacherVO> select(@Param("pageSize") int pageSize,@Param("start") int start);

    int selectCount();

    int insertSelective(TeacherVO record);

    TeacherVO selectByPrimaryKey(Integer id);

    TeacherVO selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(TeacherVO record);

    int updateByWechatId(TeacherVO record);
}