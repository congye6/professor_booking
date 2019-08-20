package cn.edu.nju.mapper;

import cn.edu.nju.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public int insert(ArticleVO articleVO);

    public List<ArticleVO> selectAll();

    public List<ArticleVO> selectTop();
}
