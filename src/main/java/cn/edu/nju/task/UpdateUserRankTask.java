package cn.edu.nju.task;

import cn.edu.nju.mapper.RankMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.RankVO;
import cn.edu.nju.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UpdateUserRankTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateUserRankTask.class);

    private static final int PAGE_SIZE = 1000;

    @Autowired
    private RankMapper rankMapper;

    @Autowired
    private UserMapper userMapper;


    @Transactional
    public void updateInstitudeRank() {
        int count = userMapper.selectCount();
        int begin = 0;
        while (begin < count) {
            LOGGER.info("********begin=" + begin);
            List<UserVO> users = userMapper.selectUser(begin, PAGE_SIZE);
            for (UserVO user : users) {
                UserVO updatedUser = new UserVO();
                updatedUser.setId(user.getId());
                RankVO rankVO = rankMapper.selectByInstitude(user.getSchool());
                updatedUser.setInstitudeRank(rankVO.getRank());
                userMapper.updateSelective(updatedUser);
            }
            begin += PAGE_SIZE;
        }
    }


}
