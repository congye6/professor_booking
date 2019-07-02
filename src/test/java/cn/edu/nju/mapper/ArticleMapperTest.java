package cn.edu.nju.mapper;

import cn.edu.nju.task.ImportArticleTask;
import cn.edu.nju.vo.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ImportArticleTask importArticleTask;

    @Test
    public void insert(){
        ArticleVO article=new ArticleVO();
        article.setCount(100);
        article.setCover("cover");
        article.setDate("2019/2/3");
        article.setLink("link...");
        article.setTitle("test");
        articleMapper.insert(article);
    }

    @Test
    public void importArticle(){
        importArticleTask.importArticle();
    }

}
