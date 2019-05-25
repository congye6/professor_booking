package cn.edu.nju.task;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRankUpdateTaskTest {

    @Autowired
    private UpdateUserRankTask task;

    @Test
    public void institude(){
        task.updateInstitudeRank();
    }


}
