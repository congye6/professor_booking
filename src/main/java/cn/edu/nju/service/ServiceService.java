package cn.edu.nju.service;

import cn.edu.nju.vo.ServiceVO;
import cn.edu.nju.vo.ResponseVO;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2018/11/09
 */
public interface ServiceService {

    /**
     * 搜索专家信息
     * @param expert 专家姓名
     * @param nation 国家
     * @param position 职位
     * @param major 专业
     * @param startPos 开始位置
     * @param num 数量
     * @return
     */
    ResponseVO expertSearch(String expert, String nation, String position,
                            String major, Integer startPos, Integer num);

    /**
     * 搜索服务信息
     * @param serviceName 服务名称
     * @param nation 国家
     * @param position 职位
     * @param school 学校
     * @param serviceType 服务类型
     * @param majorType 专业类型
     * @param startPos 开始位置
     * @param num 数量
     * @return
     */
    ResponseVO serviceSearch(String serviceName, String nation, String position, String school,
                             Integer serviceType, Integer majorType, Integer startPos, Integer num);

    /**
     * 通过专家id获取专家和其持有的服务信息
     * @param expertId 专家id
     * @return
     */
    ResponseVO getServiceByExpertId(Integer expertId);

    /**
     * 1.4
     * 专家头像，姓名，职称，服务简介，地址，预约
     * @param startPos 起始服务记录位置
     * @param number 服务数量
     * @return
     */
    ResponseVO serviceList(Integer startPos, Integer number);

    /**
     * 2.3
     * 专家头像、姓名、职位、地址、简介、专家所持有服务
     * @param serviceId 服务Id
     * @return
     */
    ResponseVO serviceDetail(Integer serviceId);

    /**
     * E1.4
     * 包括标题、正文、预约地址、预约时间、截止时间
     * @param serviceCreateVO 创建服务的信息
     * @return
     */
    ResponseVO serviceCreate(ServiceVO serviceCreateVO);

    /**
     * 删除服务
     * @param serviceId
     * @return
     */
    ResponseVO deleteService(Integer serviceId);

    /**
     * 修改服务内容
     * @return
     */
    ResponseVO modifyService(ServiceVO serviceVO);

    /**
     * 获取服务数量
     * @return
     */
    ResponseVO getServiceCount();

    /**
     * 获取所有专业类别
     * @return
     */
    ResponseVO getAllMajorType();

    /**
     * 获取所有服务类别
     * @return
     */
    ResponseVO getAllServiceType();

}
