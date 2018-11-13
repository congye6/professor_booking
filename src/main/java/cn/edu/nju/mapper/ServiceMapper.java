package cn.edu.nju.mapper;

import cn.edu.nju.vo.ServiceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

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

    /**
     * 获取服务列表
     * @param startPos
     * @param num
     * @return
     */
    List<ServiceVO> getService(@Param("startPos") int startPos, @Param("num") int num);
}
