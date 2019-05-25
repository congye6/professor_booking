package cn.edu.nju.task;

import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 将散乱的专业名称映射成几个统一的
 */
@Component
public class MajorMappingTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MajorMappingTask.class);

    private static final int PAGE_SIZE = 1000;

    private static final Map<String, String> MAJOR_MAPPING = new HashMap<>();

    static {
        MAJOR_MAPPING.put("finance", "金融");
        MAJOR_MAPPING.put("accounting", "会计");
        MAJOR_MAPPING.put("business", "商业管理");
        MAJOR_MAPPING.put("management", "商业管理");
        MAJOR_MAPPING.put("marketing", "营销");
        MAJOR_MAPPING.put("economics", "经济学");
        MAJOR_MAPPING.put("economic", "经济学");
        MAJOR_MAPPING.put("operation", "运营管理");
        MAJOR_MAPPING.put("information", "信息管理");
    }

    @Autowired
    private UserMapper userMapper;

    public void run() {
        int count = userMapper.selectCount();
        int begin = 0;
        while (begin < count) {
            LOGGER.info("********begin="+begin);
            List<UserVO> users = userMapper.selectUser(begin, PAGE_SIZE);
            for (UserVO user : users) {

                UserVO updatedUser = new UserVO();
                updatedUser.setId(user.getId());
                String introduction = user.getIntroduction();
                if(introduction.length()>1000){
                    introduction=introduction.substring(0,990)+"...";
                    updatedUser.setIntroduction(introduction);
                    userMapper.updateSelective(updatedUser);
                }
            }
            begin += PAGE_SIZE;
        }

    }


}
