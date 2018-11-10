package cn.edu.nju.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/10
 */
@Mapper
public interface ServiceMapper {

    /**
     * 新增服务记录
     * @param professorId
     * @param title
     * @param reserveAddress
     * @param reserveTime
     * @param deadline
     */
    void insertService(@Param("professorId") Integer professorId, @Param("title") String title, @Param("reserveAddress") String reserveAddress,
                       @Param("reserveTime") Timestamp reserveTime, @Param("deadline") Timestamp deadline);

}
