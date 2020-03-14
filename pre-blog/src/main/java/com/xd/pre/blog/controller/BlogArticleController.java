package com.xd.pre.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.pre.blog.domain.BlogArticle;
import com.xd.pre.blog.service.IBlogArticleService;
import com.xd.pre.common.utils.R;
import com.xd.pre.log.annotation.SysOperaLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author linfen
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/blog/article")
public class BlogArticleController {

    @Autowired
    private IBlogArticleService blogArticleService;

    /**
     * 保存文章
     *
     * @param blogArticle
     * @return
     */
    @SysOperaLog(descrption = "保存文章")
    @PostMapping
    @PreAuthorize("hasAuthority('blog:article:add')")
    public R insert(@RequestBody BlogArticle blogArticle) {
        return R.ok(blogArticleService.save(blogArticle));
    }

    /**
     * 查询文章集合
     *
     * @param page
     * @param blogArticle
     * @return
     */
    @SysOperaLog(descrption = "查询文章集合")
    @GetMapping
//    @PreAuthorize("hasAuthority('blog:article:view')")
    public R getList(Page page, BlogArticle blogArticle) {
        return R.ok(blogArticleService.page(page,Wrappers.query(blogArticle).lambda().orderByDesc(BlogArticle::getId)));
    }

    /**
     * 更新文章
     *
     * @param blogArticle
     * @return
     */
    @SysOperaLog(descrption = "更新文章")
    @PutMapping
    @PreAuthorize("hasAuthority('blog:article:update')")
    public R update(@RequestBody BlogArticle blogArticle) {
        return R.ok(blogArticleService.updateById(blogArticle));
    }

    /**
     * 根据id删除文章
     *
     * @param id
     * @return
     */
    @SysOperaLog(descrption = "根据id删除文章")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('blog:article:delete')")
    public R delete(@PathVariable("id") Integer id) {
        return R.ok(blogArticleService.removeById(id));
    }

}

