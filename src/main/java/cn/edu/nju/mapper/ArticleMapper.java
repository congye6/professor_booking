package cn.edu.nju.mapper;

import cn.edu.nju.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    public int insert(ArticleVO articleVO);

}
