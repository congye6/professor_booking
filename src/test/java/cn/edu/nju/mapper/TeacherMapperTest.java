package cn.edu.nju.mapper;

import cn.edu.nju.vo.TeacherVO;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void insert(){
        TeacherVO teacherVO=new TeacherVO();
        teacherVO.setInfoId(2);
        teacherVO.setWechatIconUrl("http");
        teacherVO.setWechatId("2222");
        teacherMapper.insertSelective(teacherVO);
    }

    @Test
    public void selectTeacher(){
        System.out.println(JSONObject.toJSONString(teacherMapper.selectByPrimaryKey(1)));
        System.out.println(JSONObject.toJSONString(teacherMapper.selectByWechatId("2222")));
    }

    @Test
    public void updateTeacher(){
        TeacherVO teacherVO=new TeacherVO();
        teacherVO.setId(1);
        teacherVO.setInfoId(3);
        teacherMapper.updateByPrimaryKeySelective(teacherVO);
    }


}
