package cn.edu.nju;

import cn.edu.nju.util.TranslateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2019-01-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslateUtilTest {

    @Autowired
    private TranslateUtil translateUtil;

    @Test
    public void translate(){
        translateUtil.translate();
    }


}
