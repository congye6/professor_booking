package cn.edu.nju;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.util.ExcelExportUtil;
import cn.edu.nju.vo.UserVO;
import jxl.write.WriteException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportUtilTest {

    @Autowired
    private UserMapper userMapper;

    private static final String[] SCHOOLS = {
            "Harvard University","University of California, Berkeley","University of Chicago","Columbia University","Massachusetts Institute of Technology","University of Oxford",
            "University of Pennsylvania","Stanford University","University of Cambridge","Yale University"
    };

    @Test
    public void export(){
        for (String school:SCHOOLS){
            String fileName = "excel/output/"+school+".xls";
            try {
                List<UserVO> users=userMapper.selectUserByInfo(school,"","","", 0, 10);
                ExcelExportUtil.exportUser(fileName,users);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


}
