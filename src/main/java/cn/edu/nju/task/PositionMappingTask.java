package cn.edu.nju.task;

import cn.edu.nju.mapper.UserMapper;
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
public class PositionMappingTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(MajorMappingTask.class);

    private static final int PAGE_SIZE = 1000;

    private static final Map<String, String> POSITION_MAPPING = new HashMap<>();

    static {
        POSITION_MAPPING.put("professor","Professor");
        POSITION_MAPPING.put("associate professor","Associate Professor");
        POSITION_MAPPING.put("assistant professor","Assistant Professor");
        POSITION_MAPPING.put("professor emeritus","Professor Emeritus");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void run() {
        int count = userMapper.selectCount();
        int begin = 0;
        while (begin < count) {
            LOGGER.info("********begin="+begin);
            List<UserVO> users = userMapper.selectUser(begin, PAGE_SIZE);
            for (UserVO user : users) {
                if(StringUtils.isEmpty(user.getPosition()))
                    continue;
                UserVO updatedUser = new UserVO();
                updatedUser.setId(user.getId());
                updatedUser.setPosition(POSITION_MAPPING.get(user.getPosition()));
                userMapper.updateSelective(updatedUser);
            }
            begin += PAGE_SIZE;
        }

    }


}
