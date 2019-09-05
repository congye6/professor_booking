package cn.edu.nju.task;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.util.ExcelUtil;
import cn.edu.nju.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UpdateIconTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateIconTask.class);

    private static final String[] SCHOOLS = {
            "Harvard University","University of California, Berkeley","University of Chicago","Columbia University","Massachusetts Institute of Technology","University of Oxford",
            "University of Pennsylvania","Stanford University","University of Cambridge","Yale University"
    };

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ExcelUtil excelUtil;


    @Transactional
    public void run() {
        for (String school: SCHOOLS){
            List<UserVO> users = excelUtil.readXlsToJson("excel/universities/"+school+".xls",UserVO.class);
            Map<String,String> iconMaps = new HashMap<>();
            for (UserVO user:users){
                if(StringUtils.isEmpty(user.getName())){
                    continue;
                }
                iconMaps.put(user.getName(),user.getIconUrl());
            }

            List<UserVO> usersInDb=userMapper.selectUserByInfo(school,"","","", 0, 100);
            for (UserVO user:usersInDb){
                String iconUrl = iconMaps.get(user.getName());
                if(StringUtils.isEmpty(iconUrl)){
                    continue;
                }

                UserVO updateUser = new UserVO();
                updateUser.setId(user.getId());
                updateUser.setIconUrl(iconUrl);
                userMapper.updateSelective(updateUser);
            }
        }
    }

}
