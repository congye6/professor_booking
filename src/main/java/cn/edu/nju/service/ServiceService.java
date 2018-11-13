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
     * 1.1
     * 可通过模糊查询查找（专家姓名)
     * 可以根据已有（学校、专业、研究方向）进行筛选
     * （结果按学校、专业排序显示）
     * @param professorName 教授姓名
     * @return
     */
    ResponseVO serviceSearchByProfessorName(String professorName);

    /**
     * 1.1
     * 可通过模糊查询查找（服务分类名)
     * 可以根据已有（学校、专业、研究方向）进行筛选
     * （结果按学校、专业排序显示）
     * @param serviceName 服务名
     * @return
     */
    ResponseVO serviceSearchByServiceName(String serviceName);

    /**
     * 1.3
     * 系统所提供的所有服务分类（签证/面试/选校/备考等）
     * 系统所提供的所有专业分类（法学/商学/计算机等）
     * @return
     */
    ResponseVO serviceClassify();

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
