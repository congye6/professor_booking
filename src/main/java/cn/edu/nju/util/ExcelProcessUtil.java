package cn.edu.nju.util;

import cn.edu.nju.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 将excel单元转成对象
 * Created by cong on 2019-01-21.
 */
@Component
public class ExcelProcessUtil {

    @Autowired
    private ExcelUtil excelUtil;

    /**
     * excel中的列名可能与对象的属性名不一致
     * 将不同的列名映射成对象属性名
     */
    private static final Map<String,String> ATTRIBUTE_MAP=new HashMap<>();

    private static final String[] ATTRIBUTES={
            "name","telephone","email","position","introduction","school","major","website","iconUrl",
            "country","researchInterest"
    };

    static {
        for(String attribute:ATTRIBUTES){//正确的属性
            ATTRIBUTE_MAP.put(attribute,attribute);
        }
        ATTRIBUTE_MAP.put("研究兴趣","researchInterest");
        ATTRIBUTE_MAP.put("头像","iconUrl");
        ATTRIBUTE_MAP.put("pic","iconUrl");
        ATTRIBUTE_MAP.put("photo","iconUrl");
        ATTRIBUTE_MAP.put("e-mail","email");
        ATTRIBUTE_MAP.put("姓名","name");
        ATTRIBUTE_MAP.put("职位","position");
        ATTRIBUTE_MAP.put("电话","telephone");
        ATTRIBUTE_MAP.put("邮箱","email");
        ATTRIBUTE_MAP.put("专业方向","major");
        ATTRIBUTE_MAP.put("背景介绍","introduction");
        ATTRIBUTE_MAP.put("个人网站","website");
        ATTRIBUTE_MAP.put("department","major");
        ATTRIBUTE_MAP.put("research interest","researchInterest");
    }

    public List<UserVO> readUsers(String path){
        List<List<String>> xlsList=excelUtil.readXls(path);
        List<UserVO> result= new ArrayList<>();
        List<String> subjectList = xlsList.get(0);

        for (int i = 1; i < xlsList.size(); i++) {
            JSONObject jsonObject = new JSONObject(true);
            for (int j = 0; j < subjectList.size(); j++){
                String attribute=ATTRIBUTE_MAP.get(subjectList.get(j));
                if(attribute==null)
                    continue;
                if(xlsList.get(i).size()<=j)//最后几行为空
                    jsonObject.put(attribute,"");
                else{
                    jsonObject.put(attribute, xlsList.get(i).get(j));
                }

//                System.out.println(jsonObject.toString());
            }
            result.add(JSONObject.parseObject(jsonObject.toString(),UserVO.class));
        }

        return result;
    }

}
