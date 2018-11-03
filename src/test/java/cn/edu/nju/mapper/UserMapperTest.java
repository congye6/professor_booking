package cn.edu.nju.mapper;

import cn.edu.nju.vo.UserVO;
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
        userVO.setWechatId("222333");
        userMapper.insertSelective(userVO);
    }

}
