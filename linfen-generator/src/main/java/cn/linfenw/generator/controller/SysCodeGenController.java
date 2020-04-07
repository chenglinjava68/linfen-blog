package cn.linfenw.generator.controller;

import cn.linfenw.common.utils.R;
import cn.linfenw.generator.service.SysCodeService;
import cn.linfenw.generator.domain.CodeGenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname SysCodeGenController
 * @Description 代码生成
 * @Author linfen
 * @Date 2019-08-02 14:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/codegen")
public class SysCodeGenController {

    @Autowired
    private SysCodeService sysCodeService;

    /**
     * 获取数据库的所有表
     *
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableList")
    public R getTableList(@RequestParam String tableSchema) {
        return R.ok(sysCodeService.findTableList(tableSchema));
    }

    /**
     * 获取表中的所有字段以及列属性
     * @param tableName
     * @param tableSchema
     * @return
     */
    @GetMapping("/getTableColumnList")
    public R getTableColumnList(@RequestParam String tableName, @RequestParam String tableSchema) {
        return R.ok(sysCodeService.findColumnList(tableName, tableSchema));
    }

    @PreAuthorize("hasAuthority('sys:codegen:codegen')")
    @PostMapping("/codegen")
    public R generatorCode(@RequestBody CodeGenConfig codeGenConfig){
        return R.ok(sysCodeService.generatorCode(codeGenConfig));
    }


}
