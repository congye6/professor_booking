package cn.edu.nju.task;

import cn.edu.nju.mapper.ArticleMapper;
import cn.edu.nju.util.ExcelUtil;
import cn.edu.nju.vo.ArticleVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImportArticleTask {

    private static final String ARTICLE_FILE_PATH = "excel/article.xlsx";

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ExcelUtil excelUtil;

    @Transactional
    public void importArticle(){
        List<ArticleVO> articles = excelUtil.readXlsToJson(ARTICLE_FILE_PATH,ArticleVO.class);
//        System.out.println(JSONObject.toJSONString(articles));
        for (ArticleVO article:articles){
            articleMapper.insert(article);
        }
    }



}
