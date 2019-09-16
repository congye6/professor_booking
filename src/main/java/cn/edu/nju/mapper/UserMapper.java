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

    List<UserVO> selectUser(@Param("start") int start,@Param("pageSize") int pageSize);

    List<UserVO> selectRandomUsers(int num);

    List<UserVO> selectSortedUser(int count);

    /**
     * 按照用户Id查找用户
     * @param id
     * @return
     */
    UserVO selectUserById(int id);

    /**
     * 总共有多少条数据
     * @return
     */
    int selectCount();

    List<String> selectCountry();

    List<String> selectPosition();

    /**
     * 通过专家姓名、国家、职位、学校查找
     * @param expert
     * @param nation
     * @param position
     * @param major
     * @return
     */
    List<UserVO> selectUserByInfo(@Param("name") String expert, @Param("nation") String nation,
                                  @Param("position") String position, @Param("major") String major);

    /**
     * 通过专家姓名、国家、职位、学校查找
     * @param expert
     * @param nation
     * @param position
     * @param major
     * @return
     */
    List<UserVO> selectUserByUniversityRank(@Param("name") String expert, @Param("nation") String nation,
                                            @Param("position") String position, @Param("major") String major);

    /**
     * 根据学校排名分页查询
     * @param startPos
     * @param num
     * @return
     */
    List<UserVO> selectUserByUniversityRankLimit(@Param("startPos") int startPos, @Param("num") int num);

    /**
     * 通过专家姓名、国家、职位、学校查找
     * @param expert
     * @param nation
     * @param position
     * @param major
     * @return
     */
    List<UserVO> selectUserByMajorRank(@Param("name") String expert, @Param("nation") String nation,
                                            @Param("position") String position, @Param("major") String major);
}