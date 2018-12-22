package cn.edu.nju.util;

import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * 导入数据
 * Created by cong on 2018-11-14.
 */
@Component
public class ImportUtil {

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RankMapper rankMapper;

    @Transactional
    public void importRank(String filePath){
        List<RankVO> list=excelUtil.readRankToJson(filePath, RankVO.class);
        for(RankVO rankVO:list){
            try{
                rankMapper.insert(rankVO);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Transactional
    public void importData(String filePath) {
        String schoolName = getSchoolName(filePath);
        List<UserVO> list = excelUtil.readXlsToJson(filePath, UserVO.class);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("no data");
        }
        System.out.println(schoolName + " data size:" + list.size());
        for (UserVO userVO : list) {
            //避免研究领域字段过长
            String interest = userVO.getMajor();
            if (interest != null && interest.length() > 50)
                userVO.setMajor(interest.substring(0, 50));

            String name = userVO.getName();
            if (!StringUtils.isEmpty(name))
                userVO.setName(name.trim());

            String position = userVO.getPosition();
            if (!StringUtils.isEmpty(position))
                userVO.setPosition(position.trim());

            String introduction=userVO.getIntroduction();
            if(!StringUtils.isEmpty(introduction)&&introduction.length()>5000)
                userVO.setIntroduction(introduction.substring(0,4990));

            String email=userVO.getEmail();
            if(!StringUtils.isEmpty(email)&&email.length()>50)
                userVO.setEmail("");

            String tel=userVO.getTelephone();
            if(!StringUtils.isEmpty(tel)&&tel.length()>50)
                userVO.setTelephone("");

            userVO.setSchool(schoolName);
            userMapper.insertSelective(userVO);

        }
        System.out.println(schoolName + " success");
    }

    private String getSchoolName(String path) {
        String[] strs = path.split("\\.");
        return strs[0].substring(6);
    }

}
