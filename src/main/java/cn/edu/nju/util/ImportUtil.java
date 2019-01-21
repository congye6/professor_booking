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
            "associate professor","assistant professor","professor emeritus","professor","lecture","chair professor"
            ,"教授","副教授","助理教授","名誉教授","讲师","讲座教授"
    };

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private ExcelProcessUtil excelProcessUtil;

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
        RankVO rank=rankMapper.selectByInstitude(schoolName);
        if(rank==null){
            System.out.println("************************");
            System.out.println("************************");
            System.out.println("invalid school:"+schoolName);
            System.out.println("************************");
            System.out.println("************************");
            return;
        }

        List<UserVO> list = excelProcessUtil.readUsers(filePath);
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("no data");
        }
        System.out.println(schoolName + " data size:" + list.size());
        for (UserVO userVO : list) {
            String position = userVO.getPosition();

            position=processPosition(position);
            if(position==null&&!StringUtils.isEmpty(userVO.getPosition())){
                System.out.println(userVO.getPosition()+" invalid");
                continue;
            }
            userVO.setPosition(position);

            NameUtil.processName(userVO);

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
            if(interest!=null&&interest.length()>1000)
                userVO.setResearchInterest(interest.substring(0,990));

            userVO.setCountry(TranslateUtil.translateCountry(userVO.getCountry()));

            String major=userVO.getMajor();
            if(major!=null&&major.length()>300)
                userVO.setMajor(major.substring(0,290));

            userVO.setSchool(schoolName);
            userVO.setInstitudeRank(rank.getRank());
            userMapper.insertSelective(userVO);

        }
        System.out.println(schoolName + " success");
    }


    private String processPosition(String str){
        if(StringUtils.isEmpty(str))
            return null;
        str=str.toLowerCase();
        for(String position:POSITIONS){
            if(str.contains(position))
                return TranslateUtil.translatePosition(position);
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
        String school=strs[0].substring(6);
        int start=0;
        for(;start<school.length();start++){
            if(isValid(school.charAt(start)))
                break;
        }
        return school.substring(start,school.length());
    }

    private boolean isValid(char c){
        if(c>='a'&&c<='z')
            return true;
        if(c>='A'&&c<='Z')
            return true;
        return false;
    }


}
