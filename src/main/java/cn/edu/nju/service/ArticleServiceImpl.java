package cn.edu.nju.service;

import cn.edu.nju.mapper.ArticleMapper;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ResponseVO getAll() {
        return ResponseVO.buildSuccess(articleMapper.selectAll());
    }

    @Override
    public ResponseVO getTop() {
        return ResponseVO.buildSuccess(articleMapper.selectTop());
    }

}
