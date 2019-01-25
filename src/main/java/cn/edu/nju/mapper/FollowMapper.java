package cn.edu.nju.mapper;

import cn.edu.nju.vo.FollowVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {

    int insert(FollowVO record);

    void delete(FollowVO record);

    /**
     * 查询是否存在
     * @param followVO
     * @return
     */
    FollowVO select(FollowVO followVO);

    /**
     * 查找学生关注的教师
     * @param studentWechatId
     * @return
     */
    List<FollowVO> selectByStudent(String studentWechatId);

    /**
     * 查找关注教师的学生
     */
    List<FollowVO> selectByTeacher(String teacherWechatId);

}