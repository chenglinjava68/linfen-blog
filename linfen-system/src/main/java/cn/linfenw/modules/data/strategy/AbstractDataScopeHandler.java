package cn.linfenw.modules.data.strategy;

import cn.linfenw.modules.data.enums.DataScopeTypeEnum;
import cn.linfenw.modules.sys.dto.RoleDTO;

import java.util.List;

/**
 * @Classname AbstractDataScopeHandler
 * @Description 创建抽象策略角色 主要作用 数据权限范围使用
 * @Author Created by Lihaodong (alias:小东啊) lihaodongmail@163.com
 * @Date 2019-06-08 15:45
 * @Version 1.0
 */

public interface AbstractDataScopeHandler {

    /**
     * @param roleDto
     * @param dataScopeTypeEnum
     * @return
     */
    List<Integer> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum);
}
