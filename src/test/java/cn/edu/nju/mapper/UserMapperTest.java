package cn.edu.nju.mapper;

import cn.edu.nju.enumeration.UserType;
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
        userVO.setCompany("gg");
        userVO.setEmail("222");
        userVO.setIconUrl("http://");
        userVO.setName("cc");
        userVO.setPhone("222");
        userVO.setWechatId("wechat4");
        userVO.setUserType(UserType.PROFESSOR);
        userMapper.insertSelective(userVO);
    }

    @Test
    public void update(){
        UserVO userVO=new UserVO();
        userVO.setCompany("ttt");
        userVO.setEmail("222@qq.com");
        userVO.setWechatId("222333");
        userMapper.updateSelective(userVO);
    }

    @Test
    public void delete(){
        userMapper.delete("wechat4");
    }

    @Test
    public void updateType(){
        userMapper.updateType("wechat3",UserType.PROFESSOR_AUDIT);
    }

    @Test
    public void select(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUser("wechat3")));;
        System.out.println(JSONObject.toJSONString(userMapper.selectUserByName("c")));
        System.out.println(JSONObject.toJSONString(userMapper.selectUserByInterest("1")));
        System.out.println(JSONObject.toJSONString(userMapper.selectUserBySchool("2")));
    }

    @Test
    public void selectAudit(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUserByType(UserType.PROFESSOR_AUDIT)));
    }



}
