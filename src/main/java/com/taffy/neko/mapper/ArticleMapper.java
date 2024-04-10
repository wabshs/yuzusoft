package com.taffy.neko.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.taffy.neko.entity.Article;
import com.taffy.neko.models.vo.ArticleVO;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {

    //自定义mapper使用分页
    List<ArticleVO> selectArticleVOByPage(IPage<ArticleVO> page);
}
