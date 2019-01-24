package cn.edu.nju.mapper;

import cn.edu.nju.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    int insertSelective(StudentVO record);

    StudentVO selectByPrimaryKey(Integer id);

    StudentVO selectByWechatId(String wechatId);

    void update(StudentVO studentVO);

    List<StudentVO> select(@Param("pageSize") int pageSize, @Param("start") int start);

    List<StudentVO> selectByAudit(@Param("isAudited") boolean isAudited,
                                  @Param("pageSize") int pageSize, @Param("start") int start);

    int selectCount();

    int selectAuditCount();
}