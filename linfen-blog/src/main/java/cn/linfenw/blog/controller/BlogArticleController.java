package cn.linfenw.blog.controller;


import cn.linfenw.blog.domain.BlogArticle;
import cn.linfenw.blog.dto.BlogArticleDTO;
import cn.linfenw.blog.dto.PigeonholeDTO;
import cn.linfenw.blog.service.IBlogArticleService;
import cn.linfenw.blog.vo.BlogArticleVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.linfenw.common.utils.R;
import cn.linfenw.log.annotation.SysOperaLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public R insert(@RequestBody BlogArticleVo blogArticle) {
        return R.ok(blogArticleService.saveArticle(blogArticle));
    }

    /**
     * 用户查询文章集合
     *
     * @param page
     * @param blogArticle
     * @return
     */
    @GetMapping
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getList(Page page, BlogArticle blogArticle) {
        QueryWrapper queryWrapper = Wrappers.query();
        if (blogArticle.getTitle()!=null&&!blogArticle.getTitle().equals("")) {
            queryWrapper.like("title", blogArticle.getTitle());
        }

        if (blogArticle.getUserId()!=null&&!blogArticle.getUserId().equals("")) {
            queryWrapper.eq("user_id", blogArticle.getUserId());
        }
        return R.ok(blogArticleService.page(page,queryWrapper));
    }

    /**
     * 查询文章集合
     *
     * @param page
     * @param blogArticle
     * @return
     */
    @GetMapping("allPage")
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getPageList(Page page, BlogArticle blogArticle) {
        return R.ok(blogArticleService.pageList(page,blogArticle));
    }

    /**
     * 查询文章集合
     *
     * @param page
     * @param title
     * @return
     */
    @GetMapping("queryArticleByName")
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getList(Page page, String title,Integer userId) {
        return R.ok(blogArticleService.pageArticleByName(page,title,userId));
    }

    /**
     * 归档查询文章集合
     *
     * @param page
     * @return
     */
    @GetMapping("queryArticlePigeonhole")
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getPigeonholeList(Page page) {
        IPage<PigeonholeDTO> listIPage = blogArticleService.pagePigeonhole(page);
        List<PigeonholeDTO> records = listIPage.getRecords();
        //年份降序
        Collections.sort(records, new Comparator<PigeonholeDTO>() {
            @Override
            public int compare(PigeonholeDTO o1, PigeonholeDTO o2) {
                return o2.getYear().compareTo(o1.getYear());
            }
        });
        listIPage.setRecords(records);
        return R.ok(listIPage);
    }

    /**
     * 标签查询文章集合
     *
     * @param page
     * @param tagId
     * @return
     */
    @GetMapping("queryArticleById")
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getPageListByTagId(Page page, Integer tagId) {
        return R.ok(blogArticleService.pageListByTagId(page,tagId));
    }

    /**
     * 查询文章Id查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("oneArticleById")
    //@PreAuthorize("hasAuthority('blog:article:view')")
    public R getOneById(Integer id) {
        BlogArticleDTO blogArticleDTO = blogArticleService.selectById(id);
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setId(blogArticleDTO.getId());
        blogArticle.setViews(blogArticleDTO.getViews() + 1);
        blogArticleDTO.setViews(blogArticle.getViews());
        blogArticleService.updateById(blogArticle);
        return R.ok(blogArticleDTO);
    }


    /**
     * 根据id查询文章
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R byId(@PathVariable("id") Integer id) {
        return R.ok(blogArticleService.queryById(id));
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
    public R update(@RequestBody BlogArticleVo blogArticle) {
        return R.ok(blogArticleService.updateArticleById(blogArticle));
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
        blogArticleService.deleteByArticleId(id);
        return R.ok();
    }

}

