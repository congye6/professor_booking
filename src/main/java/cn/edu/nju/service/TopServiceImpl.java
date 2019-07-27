package cn.edu.nju.service;

import cn.edu.nju.mapper.InstitudeMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;
import cn.edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopServiceImpl implements TopService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InstitudeMapper institudeMapper;

    @Override
    public ResponseVO getTopProfessors() {
        return ResponseVO.buildSuccess(userMapper.selectSortedUser(10));
    }

    @Override
    public ResponseVO getTopInstitude() {
        return ResponseVO.buildSuccess(institudeMapper.selectSortedInstitude(10));
    }

    /**
     * 获取热度前十的教授id
     * TODO
     * @return
     */
    private List<Integer> getTopProfessorIds(){
        return Arrays.asList(5874,58725,58726,58727,58728,58729,58730,58731,58732,58733);
    }

    /**
     * 获取热度前十的学校
     * TODO
     */
    private List<String> getTopInstitudeNames(){
        return Arrays.asList("Harvard University","Stanford University","University of Cambridge",
                "Princeton University","University of Oxford","Columbia University","University of Chicago",
                "Cornell University","Yale University","University of Washington");
    }
}
