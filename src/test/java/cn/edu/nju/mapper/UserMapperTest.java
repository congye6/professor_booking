package cn.edu.nju.mapper;

import cn.edu.nju.vo.UserVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-11-03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        UserVO userVO=new UserVO();
        userVO.setEmail("222");
        userVO.setName("cc");
        userVO.setIntroduction("jshdjddsdsd");
        userVO.setPosition("Professor");
        userVO.setResearchInterest("sddd");
        userVO.setSchool("sassd");
        userVO.setWebsite("http://localhost");
        userMapper.insertSelective(userVO);
    }

    @Test
    public void update(){
        UserVO userVO=new UserVO();
        userVO.setId(5);
        userVO.setEmail("222@qq.com");
        userVO.setSchool("233");
        userVO.setResearchInterest("update");
        userVO.setPosition("pro");
        userVO.setIntroduction("44444");
        userVO.setName("222222");
        userVO.setTelephone("222222");
        userMapper.updateSelective(userVO);
    }

    @Test
    public void delete(){
        userMapper.delete(2);
    }

    @Test
    public void select(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUserById(1)));
        System.out.println(JSONObject.toJSONString(userMapper.selectUserByName("c")));
        System.out.println(JSONObject.toJSONString(userMapper.selectUserByInterest("1")));
        System.out.println(JSONObject.toJSONString(userMapper.selectUserBySchool("2")));
    }

    @Test
    public void selectByPage(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUser(50,5)));
    }




}
