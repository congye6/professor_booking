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
     * 搜索教授名、服务标题、服务正文匹配的记录
     * @param content
     * @return
     */
    ResponseVO serviceSearch(String content);

    /**
     * 1.4
     * 专家头像，姓名，职称，服务简介，地址，预约
     * @param startPos 起始服务记录位置
     * @param number 服务数量
     * @return
     */
    ResponseVO serviceList(int startPos, int number);

    /**
     * 2.3
     * 专家头像、姓名、职位、地址、简介、专家所持有服务
     * @param serviceId 服务Id
     * @return
     */
    ResponseVO serviceDetail(int serviceId);

    /**
     * E1.4
     * 包括标题、正文、预约地址、预约时间、截止时间
     * @param serviceCreateVO 创建服务的信息
     * @return
     */
    ResponseVO serviceCreate(ServiceVO serviceCreateVO);

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
