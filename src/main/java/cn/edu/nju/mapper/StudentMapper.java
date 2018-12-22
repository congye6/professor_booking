package cn.edu.nju.mapper;

import cn.edu.nju.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(StudentVO record);

    StudentVO selectByPrimaryKey(Integer id);

    StudentVO selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(StudentVO record);

}