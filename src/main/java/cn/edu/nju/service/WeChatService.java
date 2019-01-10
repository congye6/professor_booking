package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/10
 */
public interface WeChatService {

    /**
     * 获取微信信息
     * @param appId
     * @param secret
     * @param resCode
     * @return
     */
    ResponseVO getWeChatKey(String appId, String secret, String resCode);


}
