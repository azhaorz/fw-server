package cn.iocoder.yudao.module.fw.controller.app.project;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.fw.controller.app.project.vo.*;
import cn.iocoder.yudao.module.fw.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.module.fw.service.project.ProjectService;

@Tag(name = "用户 APP - fw-项目")
@RestController
@RequestMapping("/fw/project")
@Validated
public class AppProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("/create")
    @Operation(summary = "创建fw-项目")
    public CommonResult<Long> createProject(@Valid @RequestBody AppProjectSaveReqVO createReqVO) {
        return success(projectService.createProject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新fw-项目")
    public CommonResult<Boolean> updateProject(@Valid @RequestBody AppProjectSaveReqVO updateReqVO) {
        projectService.updateProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除fw-项目")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteProject(@RequestParam("id") Long id) {
        projectService.deleteProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得fw-项目")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppProjectRespVO> getProject(@RequestParam("id") Long id) {
        ProjectDO project = projectService.getProject(id);
        return success(BeanUtils.toBean(project, AppProjectRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得fw-项目分页")
    public CommonResult<PageResult<AppProjectRespVO>> getProjectPage(@Valid AppProjectPageReqVO pageReqVO) {
        PageResult<ProjectDO> pageResult = projectService.getProjectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppProjectRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出fw-项目 Excel")
    @ApiAccessLog(operateType = EXPORT)
    public void exportProjectExcel(@Valid AppProjectPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ProjectDO> list = projectService.getProjectPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "fw-项目.xls", "数据", AppProjectRespVO.class,
                        BeanUtils.toBean(list, AppProjectRespVO.class));
    }

}