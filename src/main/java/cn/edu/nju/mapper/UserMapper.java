package cn.edu.nju.mapper;

import cn.edu.nju.enumeration.UserType;
import cn.edu.nju.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    UserVO selectUser(String wechatId);

    int insertSelective(UserVO record);

    void updateSelective(UserVO userVO);

    void delete(String wechatId);

    void updateType(@Param("wechatId") String wechatId,@Param("userType") UserType userType);

    List<UserVO> selectUserByName(String name);

    List<UserVO> selectUserBySchool(String school);

    List<UserVO> selectUserByInterest(String interest);
}