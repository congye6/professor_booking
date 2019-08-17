package cn.edu.nju.service;

import cn.edu.nju.mapper.InstitudeMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopServiceImpl implements TopService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InstitudeMapper institudeMapper;

    @Override
    public ResponseVO getTopProfessors() {
        boolean sorted = true;
        List<UserVO> topUsers = userMapper.selectSortedUser(10);
        for (UserVO user : topUsers) {
            if (user.getSort() == 0) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return ResponseVO.buildSuccess(topUsers);
        }

        List<UserVO> randomUsers = userMapper.selectRandomUsers(10);
        Set<Integer> userIds = new HashSet<>(); // 用于去重
        for (int i = 0; i < topUsers.size(); i++) {
            if (topUsers.get(i).getSort() != 0) {
                userIds.add(topUsers.get(i).getId());
                continue;
            }

            UserVO replacedUser = null;
            while (replacedUser == null) {
                replacedUser = randomUsers.get(randomUsers.size() - 1);
                randomUsers.remove(randomUsers.size() - 1);
                if (userIds.contains(replacedUser.getId())) { //重复,取下一个
                    replacedUser = null;
                }
            }
            topUsers.set(i, replacedUser); // 未排序的，替换随机用户
        }
        return ResponseVO.buildSuccess(topUsers);
    }

    @Override
    public ResponseVO getTopInstitude() {
        boolean sorted = true;
        List<InstitudeVO> topInstitudes = institudeMapper.selectSortedInstitude(10);
        for (InstitudeVO institudeVO : topInstitudes) {
            if (institudeVO.getSort() == 0) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return ResponseVO.buildSuccess(topInstitudes);
        }

        List<InstitudeVO> randomInstitudes = institudeMapper.selectRandomInstitude(10);
        Set<Integer> institudeIds = new HashSet<>(); // 用于去重
        for (int i = 0; i < topInstitudes.size(); i++) {
            if (topInstitudes.get(i).getSort() != 0) {
                institudeIds.add(topInstitudes.get(i).getId());
                continue;
            }

            InstitudeVO replacedInstitude = null;
            while (replacedInstitude == null) {
                replacedInstitude = randomInstitudes.get(randomInstitudes.size() - 1);
                randomInstitudes.remove(randomInstitudes.size() - 1);
                if (institudeIds.contains(replacedInstitude.getId())) { //重复,取下一个
                    replacedInstitude = null;
                }
            }
            topInstitudes.set(i, replacedInstitude); // 未排序的，替换随机学校
        }
        return ResponseVO.buildSuccess(topInstitudes);
    }

    /**
     * 获取热度前十的教授id
     * TODO
     *
     * @return
     */
    private List<Integer> getTopProfessorIds() {
        return Arrays.asList(5874, 58725, 58726, 58727, 58728, 58729, 58730, 58731, 58732, 58733);
    }

    /**
     * 获取热度前十的学校
     * TODO
     */
    private List<String> getTopInstitudeNames() {
        return Arrays.asList("Harvard University", "Stanford University", "University of Cambridge",
                "Princeton University", "University of Oxford", "Columbia University", "University of Chicago",
                "Cornell University", "Yale University", "University of Washington");
    }
}
