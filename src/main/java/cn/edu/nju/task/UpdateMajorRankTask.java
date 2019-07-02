package cn.edu.nju.task;

import cn.edu.nju.mapper.MajorRankMapper;
import cn.edu.nju.mapper.UserMapper;
import cn.edu.nju.util.ExcelUtil;
import cn.edu.nju.vo.InstitudeVO;
import cn.edu.nju.vo.MajorMappingVO;
import cn.edu.nju.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专业映射 and 专业排名更新
 */
@Service
public class UpdateMajorRankTask {

    private static final int PAGE_SIZE = 1000;

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MajorRankMapper majorRankMapper;

    public void execute(String filePath) {
        List<MajorMappingVO> list = excelUtil.readXlsToJson(filePath, MajorMappingVO.class);

        Map<String, MajorMappingVO> majorMap = new HashMap<>();
        for (MajorMappingVO majorMapping : list) {
            majorMapping.setMajorType(majorMapping.getMajorType().substring(4)); //去掉rank前缀
            majorMap.put(majorMapping.getOldMajor(), majorMapping);
        }
        int count = userMapper.selectCount();
        System.out.println("user count=" + count);
        int begin = 0;
        int successCount = 0;
        while (begin < count) {
            System.out.println("********begin=" + begin);
            List<UserVO> users = userMapper.selectUser(begin, PAGE_SIZE);
            for (UserVO user : users) {
                if (StringUtils.isEmpty(user.getMajor())) {
                    continue;
                }
                UserVO updatedUser = new UserVO();
                updatedUser.setId(user.getId());
                String oldMajor = user.getMajor().trim();
                MajorMappingVO majorMapping = majorMap.get(oldMajor);
                if (majorMapping == null){
                    System.out.println("invalid major:"+user.getMajor());
                    continue;
                }
                updatedUser.setMajor(majorMapping.getNewMajor());
                Double majorRank=majorRankMapper.selectRank(user.getSchool(),majorMapping.getMajorType());
                if (majorRank != null){
                    System.out.println("invalid rank,school:"+user.getSchool()+" major type:"+majorMapping.getMajorType());
                    updatedUser.setMajorRank(majorRank);
                }
                successCount++;
                userMapper.updateSelective(updatedUser);
            }
            begin += PAGE_SIZE;
        }
        System.out.println("success count:"+successCount);
    }


}
