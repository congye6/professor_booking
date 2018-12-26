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
        userVO.setMajor("sddd");
        userVO.setSchool("sassd");
        userVO.setWebsite("http://localhost");
        userVO.setCountry("中国");
        userVO.setResearchInterest("22");
        userVO.setFirstName("ccc");
        userVO.setFamilyName("ccccc");
        userVO.setInstitudeRank(1);
        userMapper.insertSelective(userVO);
    }

    @Test
    public void update(){
        UserVO userVO=new UserVO();
        userVO.setId(2410);

        userVO.setFamilyName("111");
        userVO.setInstitudeRank(2);
        userVO.setFirstName("111111");
        userVO.setResearchInterest("ssssssssss");
        userMapper.updateSelective(userVO);
    }

    @Test
    public void delete(){
        userMapper.delete(2);
    }

    @Test
    public void select(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUserById(1555)));

    }

    @Test
    public void selectByPage(){
        System.out.println(JSONObject.toJSONString(userMapper.selectUser(50,5)));
    }

    @Test
    public void selectCount(){
        long begin=System.currentTimeMillis();
        System.out.println(userMapper.selectCount());
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }



}
