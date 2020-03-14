package com.xd.pre.blog.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 友联网站
 * </p>
 *
 * @author linfen
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogLink extends BaseDomain implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 描述
     */
    private String descriptions;

    /**
     * logo
     */
    private String logo;

    /**
     * 网站地址
     */
    private String linkAddress;

    /**
     * 访问量
     */
    private Long pv;

    /**
     * 状态（0审核中，1审核通过，2禁止访问，3隐藏）
     */
    private Integer status;

    private Integer tenantId;


}
