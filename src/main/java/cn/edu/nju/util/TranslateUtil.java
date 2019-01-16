package cn.edu.nju.util;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by cong on 2019-01-12.
 */
@Component
public class TranslateUtil {


    @Autowired
    private UserMapper userMapper;

    private static final Map<String,String> COUNTRY_MAP=new HashMap<>();

    private static final Map<String,String> POSITION_MAP=new HashMap<>();

    private static final int PAGE_SIZE=500;

    static {
        COUNTRY_MAP.put("England","英国");
        COUNTRY_MAP.put("America","美国");
        COUNTRY_MAP.put("China","中国");

        POSITION_MAP.put("Professor","教授");
        POSITION_MAP.put("Associate Professor","副教授");
        POSITION_MAP.put("Assistant Professor","助理教授");
        POSITION_MAP.put("Professor Emeritus","名誉教授");
        POSITION_MAP.put("Lecture","讲师");
        POSITION_MAP.put("Chair Professor","讲座教授");
    }

    public void translate(){
        int count=userMapper.selectCount();
        int begin=0;
        while(begin<count){
            List<UserVO> users=userMapper.selectUser(begin,PAGE_SIZE);
            for(UserVO user:users){
                user.setCountry(COUNTRY_MAP.get(user.getCountry()));
                user.setPosition(POSITION_MAP.get(user.getPosition()));
                userMapper.updateSelective(user);
            }
            begin+=PAGE_SIZE;
        }
    }

    public static String translatePosition(String position){
        return POSITION_MAP.get(position);
    }

    public static String translateCountry(String country){
        String translate=COUNTRY_MAP.get(country);
        if(translate==null)
            return country;
        return translate;
    }
}
