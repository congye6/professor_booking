package cn.edu.nju;

import cn.edu.nju.util.ImportUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Created by cong on 2018-11-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportTest {

    @Autowired
    private ImportUtil importUtil;

    @Test
    public void importData() {
        //importUtil.importData("excel/Berkeley.xlsx");
        String dirName="excel/";
        File dir = new File(dirName);
        String[] excels=dir.list();
        for(String excel:excels){
            importUtil.importData(dirName+excel);
        }
    }


}
