package cn.edu.nju.util;

import cn.edu.nju.vo.UserVO;
import org.springframework.util.StringUtils;

/**
 * Created by cong on 2019-01-14.
 */
public class NameUtil {

    public static void processName(UserVO userVO){
        String name = userVO.getName();
        name=name.trim();
        if (StringUtils.isEmpty(name)){
            return;
        }
        userVO.setName(name);
        String[] spliters={
                ","," "
        };
        String[] names=null;
        String spliterSelected="";
        for(String spliter:spliters){
            names=name.split(spliter);
            spliterSelected=spliter;
            if(names.length!=1)
                break;
        }

        if(names.length==1){
            userVO.setFamilyName(name);
        }else if(names.length==2){
            userVO.setFamilyName(names[1].trim());
            userVO.setFirstName(names[0].trim());
        }else{
            userVO.setFamilyName(names[names.length-1].trim());
            int lastNameIndex=name.lastIndexOf(spliterSelected);
            userVO.setFirstName(name.substring(0,lastNameIndex));
        }
    }

}
