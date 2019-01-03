package cn.edu.nju.vo;

/**
 * 包括教师用户信息和爬取的信息
 * Created by cong on 2019-01-03.
 */
public class TeacherDetailVO extends UserVO{

    private String wechatId;

    private String wechatIconUrl;

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatIconUrl() {
        return wechatIconUrl;
    }

    public void setWechatIconUrl(String wechatIconUrl) {
        this.wechatIconUrl = wechatIconUrl;
    }
}
