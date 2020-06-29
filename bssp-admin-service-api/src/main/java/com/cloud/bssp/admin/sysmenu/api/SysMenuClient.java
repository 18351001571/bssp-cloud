package com.cloud.bssp.admin.sysmenu.api;

import com.cloud.bssp.api.common.util.R;
import com.cloud.bssp.admin.sysmenu.dto.SysMenuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
/**
 * <p>
 * SysMenuClient
 * </p>
 *
 * @author weirx
 * @since 2020-06-23
 */
@FeignClient(name = "bssp-data-service", path = "/sysmenu", contextId = "base")
public interface SysMenuClient {

    /**
     * 分页列表
     * @param params
     * @return
     */
    @PostMapping("/pageList")
    R pageList(@RequestBody Map<String, Object> params);

    /**
     * list列表
     * @param sysMenuDTO
     * @return
     */
    @PostMapping("/list")
    R list(@RequestBody SysMenuDTO sysMenuDTO);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @GetMapping("/info/getById")
    R info(@RequestParam("id") Long id);

    /**
     * 新增
     * @param sysMenuDTO
     * @return
     */
    @PostMapping("/save")
    R save(@RequestBody SysMenuDTO sysMenuDTO);

    /**
     * 更新
     * @param sysMenuDTO
     * @return
     */
    @PostMapping("/update")
    R update(@RequestBody SysMenuDTO sysMenuDTO);
}