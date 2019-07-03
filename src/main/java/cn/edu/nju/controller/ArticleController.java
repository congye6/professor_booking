package cn.edu.nju.controller;

import cn.edu.nju.service.ArticleService;
import cn.edu.nju.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public ResponseVO getAll(){
        return articleService.getAll();
    }


}
