package cn.edu.nju.vo;

public class ArticleVO {

    private Integer id;

    private String title;

    /**
     * 日期
     */
    private String date;

    /**
     * 跳转链接
     */
    private String link;

    /**
     * 封面链接
     */
    private String cover;

    /**
     * 阅读数量
     */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
