package cn.edu.nju.mapper;

import cn.edu.nju.vo.InstitudeVO;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-09.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InstitudeMapperTest {

    @Autowired
    private InstitudeMapper mapper;

    @Test
    public void addRank(){
        InstitudeVO institudeVO =new InstitudeVO();
        institudeVO.setInstitude("cccc");
        institudeVO.setRank(12.0);
        mapper.insert(institudeVO);
    }

    @Test
    public void selectAll(){
        System.out.println(JSONObject.toJSONString(mapper.selectAll()));
        System.out.println(JSONObject.toJSONString(mapper.selectByInstitude("Harvard University")));
    }

    @Test
    public void update(){
        InstitudeVO institudeVO =new InstitudeVO();
        institudeVO.setRank(1.0);
        institudeVO.setInstitude("Harvard University");
        mapper.updateByInstitude(institudeVO);
    }

}
