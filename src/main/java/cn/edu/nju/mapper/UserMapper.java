package cn.edu.nju.mapper;

import cn.edu.nju.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertSelective(UserVO record);
}