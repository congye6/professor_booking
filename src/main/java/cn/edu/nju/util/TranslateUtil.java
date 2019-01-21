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

    private static final String[] POSITIONS={
            "教授","副教授","助理教授","名誉教授","讲师","讲座教授"
    };

    static {
        COUNTRY_MAP.put("England","英国");
        COUNTRY_MAP.put("America","美国");
        COUNTRY_MAP.put("China","中国");

        POSITION_MAP.put("professor","教授");
        POSITION_MAP.put("associate professor","副教授");
        POSITION_MAP.put("assistant professor","助理教授");
        POSITION_MAP.put("professor emeritus","名誉教授");
        POSITION_MAP.put("lecture","讲师");
        POSITION_MAP.put("chair professor","讲座教授");
        for(String position:POSITIONS){
            POSITION_MAP.put(position,position);
        }
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
