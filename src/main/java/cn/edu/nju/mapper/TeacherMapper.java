package cn.edu.nju.mapper;

import cn.edu.nju.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TeacherVO record);

    TeacherVO selectByPrimaryKey(Integer id);

    TeacherVO selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(TeacherVO record);
}