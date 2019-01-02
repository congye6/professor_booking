package cn.edu.nju.mapper;

import cn.edu.nju.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int insertSelective(StudentVO record);

    StudentVO selectByPrimaryKey(Integer id);

    StudentVO selectByWechatId(String wechatId);

    void update(StudentVO studentVO);

}