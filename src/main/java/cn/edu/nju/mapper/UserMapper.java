package cn.edu.nju.mapper;

import cn.edu.nju.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertSelective(UserVO record);

    void updateSelective(UserVO userVO);

    void delete(int id);

    List<UserVO> selectUserByName(String name);

    List<UserVO> selectUserBySchool(String school);

    List<UserVO> selectUserByInterest(String interest);

    /**
     * 按照用户Id查找用户
     * @param id
     * @return
     */
    UserVO selectUserById(int id);
}