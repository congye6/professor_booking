package cn.edu.nju.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionMappingTaskTest {

    @Autowired
    private PositionMappingTask task;

    @Test
    public void mapping(){
        task.run();
    }


}
