package cn.edu.nju.mapper;

import cn.edu.nju.vo.RankVO;
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
public class RankMapperTest {

    @Autowired
    private RankMapper mapper;

    @Test
    public void addRank(){
        RankVO rankVO=new RankVO();
        rankVO.setInstitude("cccc");
        rankVO.setRank(12.0);
        mapper.insert(rankVO);
    }

    @Test
    public void selectAll(){
        System.out.println(JSONObject.toJSONString(mapper.selectAll()));
        System.out.println(JSONObject.toJSONString(mapper.selectByInstitude("Harvard University")));
    }

    @Test
    public void update(){
        RankVO rankVO=new RankVO();
        rankVO.setRank(1.0);
        rankVO.setInstitude("Harvard University");
        mapper.updateByInstitude(rankVO);
    }

}
