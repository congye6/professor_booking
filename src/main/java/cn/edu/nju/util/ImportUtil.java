package cn.edu.nju.util;

import cn.edu.nju.mapper.MajorRankMapper;
import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.MajorRankVO;
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

    private static final String[] POSITIONS={
            "Associate Professor","Assistant Professor","Professor Emeritus","Professor"
    };

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RankMapper rankMapper;

    @Autowired
    private MajorRankMapper majorRankMapper;


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
    public void importMajorRank(String filePath){
        List<MajorRankVO> list=excelUtil.readMajorRank(filePath);
        for(MajorRankVO rankVO:list){
            try{
                majorRankMapper.insert(rankVO);
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
            String position = userVO.getPosition();

            if(schoolName.equals("Yale University")){
                userVO.setMajor(getMajorFromPosition(userVO.getPosition()));
            }

            position=processPosition(position);
            if(position==null){
                System.out.println(userVO.getPosition()+" invalid");
                continue;
            }
            userVO.setPosition(position);

            processName(userVO);

            String introduction=userVO.getIntroduction();
            if(!StringUtils.isEmpty(introduction)&&introduction.length()>5000)
                userVO.setIntroduction(introduction.substring(0,4990));

            String email=userVO.getEmail();
            if(!StringUtils.isEmpty(email)&&email.length()>100)
                userVO.setEmail("");

            String tel=userVO.getTelephone();
            if(!StringUtils.isEmpty(tel)&&tel.length()>100)
                userVO.setTelephone("");

            String interest=userVO.getResearchInterest();
            if(interest==null||interest.length()>1000)
                userVO.setResearchInterest("");

            userVO.setSchool(schoolName);
            RankVO rank=rankMapper.selectByInstitude(schoolName);
            userVO.setInstitudeRank(rank.getRank());
            userMapper.insertSelective(userVO);

        }
        System.out.println(schoolName + " success");
    }

    public void processName(UserVO userVO){
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

    private String processPosition(String str){
        for(String position:POSITIONS){
            if(str.contains(position))
                return position;
        }
        return null;
    }

    public String getMajorFromPosition(String position){
        String[] strs=position.split(" of ");
        if(strs.length!=2)
            return "";
        return strs[1].trim();
    }

    private String getSchoolName(String path) {
        String[] strs = path.split("\\.");
        return strs[0].substring(6);
    }


}
