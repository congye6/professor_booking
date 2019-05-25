package cn.edu.nju.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankUpdateTaskTest {

    @Autowired
    private RankUpdateTask task;

    @Test
    public void updateInstitude(){
        task.updateInstitude("excel/rank.xlsx");
    }

    @Test
    public void insertMajorRank(){
        task.insertMajorRank("excel/major_rank.xlsx");
    }
}
