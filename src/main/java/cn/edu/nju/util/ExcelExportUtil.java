package cn.edu.nju.util;


import cn.edu.nju.vo.UserVO;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ExcelExportUtil {

    private static final String[] USER_FIELDS = {
            "name","telephone","email","position","school","major","iconUrl","website","country","institudeRank","majorRank",
            "researchInterest","introduction"
    };

    public static void exportUser(String fileName, List<UserVO> users) throws IOException, WriteException, NoSuchFieldException, IllegalAccessException {
        File file=new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        //以fileName为文件名来创建一个Workbook
        WritableWorkbook wwb = Workbook.createWorkbook(file);

        // 创建工作表
        WritableSheet ws = wwb.createSheet("Sheet 1", 0);


        //初始化列名
        for (int i=0;i<USER_FIELDS.length;i++){
            String field = USER_FIELDS[i];
            Label label = new Label(i,0,field);
            ws.addCell(label);
        }

        Class<UserVO> userClass = UserVO.class;
        for (int i = 0; i < users.size(); i++) {
            for (int j=0;j<USER_FIELDS.length;j++){
                String fieldName = USER_FIELDS[j];
                UserVO userVO = users.get(i);
                Field filed=userClass.getField(fieldName);
                Object value=filed.get(userVO);

                String str="";
                if(value!=null){
                    str=value.toString();
                }
                System.out.println(str);
                Label label=new Label(j,i+1,str);
                ws.addCell(label);
            }
        }

        //写进文档
        wwb.write();
        // 关闭Excel工作簿对象
        System.out.println("数据导出成功!");
        wwb.close();
    }


}
