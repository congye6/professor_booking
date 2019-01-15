package cn.edu.nju.mapper;

import cn.edu.nju.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    List<TeacherVO> selectByName(String wechatName);

    int insertSelective(TeacherVO record);

    TeacherVO selectByPrimaryKey(Integer id);

    TeacherVO selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(TeacherVO record);

    int updateByWechatId(TeacherVO record);
}