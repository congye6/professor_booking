package cn.edu.nju.service;

import cn.edu.nju.mapper.InstitudeMapper;
import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2019-01-01.
 */
@Service
public class InstitudeServiceImpl implements InstitudeService {

    @Autowired
    private InstitudeMapper institudeMapper;

    @Override
    public ResponseVO getInstitude(String institude) {
        return ResponseVO.buildSuccess(institudeMapper.selectByInstitude(institude));
    }

    @Override
    public ResponseVO getAllInstitude() {
        return ResponseVO.buildSuccess(institudeMapper.selectAll());
    }

    @Override
    public ResponseVO insertInstitude(InstitudeVO institudeVO) {
        InstitudeVO rankInDb= institudeMapper.selectByInstitude(institudeVO.getInstitude());
        if(rankInDb!=null)
            return ResponseVO.buildFailure(institudeVO.getInstitude()+"排名已存在");
        institudeMapper.insert(institudeVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateInstitude(InstitudeVO institudeVO) {
        institudeMapper.updateByInstitude(institudeVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteInstitude(String name) {
        institudeMapper.deleteByInstitude(name);
        return ResponseVO.buildSuccess();
    }
}
