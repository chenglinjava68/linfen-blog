package com.xd.pre.blog.service;

import com.xd.pre.blog.domain.BlogDiscuss;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author linfen
 * @since 2020-03-13
 */
public interface IBlogDiscussService extends IService<BlogDiscuss> {
    public List<BlogDiscuss> getRootBlogDiscussByArticleId(Integer articleId) ;
}
