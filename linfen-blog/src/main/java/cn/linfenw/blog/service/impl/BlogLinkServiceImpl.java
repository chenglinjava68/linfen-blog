package cn.linfenw.blog.service.impl;

import cn.linfenw.blog.domain.BlogLink;
import cn.linfenw.blog.dto.LinkDTO;
import cn.linfenw.blog.mapper.BlogLinkMapper;
import cn.linfenw.blog.service.IBlogLinkService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 友联网站 服务实现类
 * </p>
 *
 * @author linfen
 * @since 2020-03-13
 */
@Service
public class BlogLinkServiceImpl extends ServiceImpl<BlogLinkMapper, BlogLink> implements IBlogLinkService {

    @Override
    public IPage<LinkDTO> orderByAll(Page page, BlogLink blogLink) {
        return baseMapper.orderByAll(page,blogLink);
    }

    @Override
    public Integer updateVisibleById(BlogLink blogLink) {
        return baseMapper.updateVisibleById(blogLink);
    }
}
