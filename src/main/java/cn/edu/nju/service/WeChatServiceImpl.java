package cn.edu.nju.service;

import cn.edu.nju.vo.ResponseVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2019/01/10
 */
@Service
public class WeChatServiceImpl implements WeChatService{

    private static final String WECHAT_URI = "https://api.weixin.qq.com/sns/jscode2session";

    private RestTemplate restTemplate;

    public WeChatServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseVO getWeChatKey(String appId, String secret, String resCode) {
        String professorUri = WECHAT_URI + "?appid=" + appId +"&secret=" + secret +
                "&grant_type=authorization_code&js_code=" + resCode;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String resBody=restTemplate.exchange(professorUri, HttpMethod.GET, entity, String.class).getBody();

        return ResponseVO.buildSuccess(resBody);
    }
}
