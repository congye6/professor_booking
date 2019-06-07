package cn.edu.nju;

import cn.edu.nju.util.ImportUtil;
import cn.edu.nju.util.NameUtil;
import cn.edu.nju.vo.UserVO;
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

    @Test
    public void importMajorRank(){
        importUtil.importMajorRank("excel/rank.xlsx");
    }


    @Test
    public void processName(){
        UserVO userVO=new UserVO();
        userVO.setName("Zuckerman Sivan Ezra W.");
        NameUtil.processName(userVO);
        System.out.println(userVO.getFirstName()+":"+userVO.getFamilyName());
        userVO.setName("wwww s");
        NameUtil.processName(userVO);
        System.out.println(userVO.getFirstName()+":"+userVO.getFamilyName());
        userVO.setName("www,eee,rrr,eeeee");
        NameUtil.processName(userVO);
        System.out.println(userVO.getFirstName()+":"+userVO.getFamilyName());
    }

    @Test
    public void getMajor(){
        System.out.println(importUtil.getMajorFromPosition("Deputy Dean for Academic Programs and Professor in the Practice of Management"));
        System.out.println(importUtil.getMajorFromPosition("Associate Professor of Organizational Behavior"));
    }
}
