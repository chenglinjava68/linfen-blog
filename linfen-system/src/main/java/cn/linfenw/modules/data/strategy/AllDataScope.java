package cn.linfenw.modules.data.strategy;

import cn.linfenw.modules.data.enums.DataScopeTypeEnum;
import cn.linfenw.modules.sys.domain.SysDept;
import cn.linfenw.modules.sys.dto.RoleDTO;
import cn.linfenw.modules.sys.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname AllDataScope
 * @Description 所有
 * @Author linfen
 * @Date 2019-06-08 16:27
 * @Version 1.0
 */
@Component("1")
public class AllDataScope implements AbstractDataScopeHandler {

    @Autowired
    private ISysDeptService deptService;


    @Override
    public List<Integer> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
        List<SysDept> sysDepts = deptService.list();
        return sysDepts.stream().map(SysDept::getDeptId).collect(Collectors.toList());
    }
}
