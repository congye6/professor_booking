package cn.edu.nju.service;

import cn.edu.nju.mapper.*;
import cn.edu.nju.vo.*;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/09
 */
@Service
public class ServiceServiceImpl implements ServiceService {

    public static final String ORDER_BY_UNIVERSITY = "orderByUniversity";

    public static final String ORDER_BY_MAJOR = "orderByMajor";

    private UserMapper userMapper;

    private ServiceMapper serviceMapper;

    private MajorTypeMapper majorTypeMapper;

    private ServiceTypeMapper serviceTypeMapper;

    private ServiceExpertMapper serviceExpertMapper;

    public ServiceServiceImpl(UserMapper userMapper, ServiceMapper serviceMapper,
                              MajorTypeMapper majorTypeMapper, ServiceTypeMapper serviceTypeMapper,
                              ServiceExpertMapper serviceExpertMapper){
        this.userMapper = userMapper;
        this.serviceMapper = serviceMapper;
        this.majorTypeMapper = majorTypeMapper;
        this.serviceTypeMapper = serviceTypeMapper;
        this.serviceExpertMapper = serviceExpertMapper;
    }

    @Override
    public ResponseVO expertSearch(String expert, String nation, String position,
                                   String major,Integer startPos, Integer num, String orderBy) {
        if(null == startPos){
            startPos = 0;
        }

        if(null == num){
            num = 50;
        }

        List<UserVO> searchExpertList;
        if(ORDER_BY_MAJOR.equals(orderBy)){
            searchExpertList = userMapper.selectUserByMajorRank(expert, nation, position, major);
        }else if(ORDER_BY_UNIVERSITY.equals(orderBy)){
            searchExpertList = userMapper.selectUserByUniversityRank(expert, nation, position, major);
        }else {
            searchExpertList = userMapper.selectUserByInfo(expert, nation, position, major, startPos, num);
        }

        Set<Integer> containIdxSet = new HashSet<>();
        UserVO userVO;
        String school;
        for(int i=0; i<searchExpertList.size(); i++){
            userVO = searchExpertList.get(i);
            school = userVO.getSchool();
            if(!StringUtils.isEmpty(school) && school.contains(expert)){
                containIdxSet.add(i);
            }
        }

        List<UserVO> containList = new ArrayList<>();
        List<UserVO> notContainList = new ArrayList<>();
        for(int i=0 ;i<searchExpertList.size(); i++){
            if(containIdxSet.contains(i)){
                containList.add(searchExpertList.get(i));
            }else {
                notContainList.add(searchExpertList.get(i));
            }
        }

        List<UserVO> sortRes = new ArrayList<>();
        for(UserVO containUser: containList){
            sortRes.add(containUser);
        }
        for(UserVO notContainUser: notContainList){
            sortRes.add(notContainUser);
        }

        List<UserVO> res = new ArrayList<>();
        for(int i = startPos; i < Math.min(startPos + num, sortRes.size()); i++){
            res.add(sortRes.get(i));
        }

        return ResponseVO.buildSuccess(res);
    }

    @Override
    public ResponseVO serviceSearch(String serviceName, String nation, String position, String school,
                                    Integer serviceType, Integer majorType, Integer startPos, Integer num) {
        if(StringUtils.isEmpty(serviceName) && StringUtils.isEmpty(nation) &&
                StringUtils.isEmpty(position) && StringUtils.isEmpty(school) &&
                serviceType == null && majorType == null){
            return ResponseVO.buildFailure("服务搜索输入信息为空");
        }

        if(null == startPos){
            startPos = 0;
        }

        if(null == num){
            num = 50;
        }

        serviceType = serviceType == null ? 0:serviceType;
        majorType = majorType == null ? 0:majorType;

        List<ServiceExpertVO> serviceExpertVOList = serviceExpertMapper.getSearchExpertInfo(serviceName, nation,
                position, school, serviceType, majorType, startPos, num);
        return ResponseVO.buildSuccess(serviceExpertVOList);
    }

    @Override
    public ResponseVO getServiceByExpertId(Integer expertId) {
        UserVO expert = userMapper.selectUserById(expertId);
        List<ServiceVO> serviceVOList = serviceMapper.getServiceListByExpertId(expertId);
        ExpertServiceVO expertServiceVO = new ExpertServiceVO();
        expertServiceVO.setExpert(expert);
        expertServiceVO.setServiceList(serviceVOList);

        return ResponseVO.buildSuccess(expertServiceVO);
    }

    @Override
    public ResponseVO serviceList(Integer startPos, Integer number) {
        if(startPos < 0){
            return ResponseVO.buildFailure("服务记录起始位置不能为负");
        }else if(number <=0){
            return ResponseVO.buildFailure("服务的数量应为正数");
        }

        List<ServiceVO> serviceVOList = serviceMapper.getServiceList(startPos, number);
        List<ServiceBriefVO> serviceBriefVOList = serviceVOList.stream().map(serviceVO -> {
            int professorId = serviceVO.getProfessorId();
            UserVO userVO = userMapper.selectUserById(professorId);
            ServiceBriefVO serviceBriefVO = new ServiceBriefVO();
            serviceBriefVO.setServiceVO(serviceVO);
            serviceBriefVO.setProfessorId(userVO.getId());
            serviceBriefVO.setProfessorName(userVO.getName());
            serviceBriefVO.setIconUrl(userVO.getIconUrl());
            serviceBriefVO.setPosition(userVO.getPosition());
            return serviceBriefVO;
        }).collect(Collectors.toList());

        return ResponseVO.buildSuccess(serviceBriefVOList);
    }

    @Override
    public ResponseVO serviceDetail(Integer serviceId) {
        ServiceVO serviceVO = serviceMapper.getServiceById(serviceId);
        if(null == serviceVO){
            return ResponseVO.buildFailure("该服务Id对应的服务不存在");
        }

        int professorId = serviceVO.getProfessorId();
        UserVO professor = userMapper.selectUserById(professorId);
        if(null == professor){
            return ResponseVO.buildFailure("该服务Id对应的专家不存在");
        }

        ServiceDetailVO serviceDetailVO = new ServiceDetailVO();
        serviceDetailVO.setUserVO(professor);
        serviceDetailVO.setServiceVO(serviceVO);

        return ResponseVO.buildSuccess(serviceDetailVO);
    }

    @Override
    public ResponseVO serviceCreate(ServiceVO vo) {
        Integer professorId = vo.getProfessorId();
        String title = vo.getTitle();
        String content = vo.getContent();
        String reserveAddress = vo.getReserveAddress();
        Timestamp reserveTime = vo.getReserveTime();
        Timestamp deadline = vo.getDeadline();
        Integer serviceTypeId = vo.getServiceTypeId();
        Integer majorTypeId = vo.getMajorTypeId();
        Integer price = vo.getPrice();

        if(null == professorId){
            return ResponseVO.buildFailure("专家编号不能为空");
        }else if(StringUtils.isEmpty(title)){
            return ResponseVO.buildFailure("标题不能为空");
        }else if (StringUtils.isEmpty(content)){
            return ResponseVO.buildFailure("正文不能为空");
        }else if(StringUtils.isEmpty(reserveAddress)){
            return ResponseVO.buildFailure("预约地址不能为空");
        }else if(null == reserveTime){
            return ResponseVO.buildFailure("预约时间不能为空");
        }else if(null == deadline){
            return ResponseVO.buildFailure("截止时间不能为空");
        }else if(null == serviceTypeId){
            return ResponseVO.buildFailure("服务类型Id不能为空");
        }else if(null == majorTypeId){
            return ResponseVO.buildFailure("专业类型Id不能为空");
        }else if(null == price){
            return ResponseVO.buildFailure("价格不能为空");
        }

        serviceMapper.insertService(professorId, title, content, reserveAddress, reserveTime, deadline, serviceTypeId, majorTypeId, price);
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public ResponseVO deleteService(Integer serviceId) {
        if(null == serviceId){
            return ResponseVO.buildFailure("服务id为空");
        }
        serviceMapper.deleteService(serviceId);
        return ResponseVO.buildSuccess();
    }


    @Override
    public ResponseVO modifyService(ServiceVO serviceVO) {
        Integer serviceId = serviceVO.getId();
        if (null == serviceId){
            return ResponseVO.buildFailure("待修改的服务Id为空");
        }

        int count = serviceMapper.updateService(serviceVO);
        if(count == 1){
            return ResponseVO.buildSuccess("修改成功");
        }else {
            return ResponseVO.buildFailure("未修改成功");
        }
    }

    @Override
    public ResponseVO getServiceCount() {
        int serviceNum = serviceMapper.getCount();
        return ResponseVO.buildSuccess(serviceNum);
    }

    @Override
    public ResponseVO getAllMajorType() {
        List<MajorTypeVO> majorTypeVOList = majorTypeMapper.getAllMajorType();
        return ResponseVO.buildSuccess(majorTypeVOList);
    }

    @Override
    public ResponseVO getAllServiceType() {
        List<ServiceTypeVO> serviceTypeVOList = serviceTypeMapper.getAllServiceType();
        return ResponseVO.buildSuccess(serviceTypeVOList);
    }
}
