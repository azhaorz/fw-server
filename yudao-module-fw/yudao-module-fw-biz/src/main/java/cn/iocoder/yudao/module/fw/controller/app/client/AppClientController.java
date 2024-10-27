package cn.iocoder.yudao.module.fw.controller.app.client;

import cn.iocoder.yudao.framework.ip.core.utils.AreaUtils;
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
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

import cn.iocoder.yudao.module.fw.controller.app.client.vo.*;
import cn.iocoder.yudao.module.fw.dal.dataobject.client.ClientDO;
import cn.iocoder.yudao.module.fw.service.client.ClientService;

@Tag(name = "用户 APP - 客户")
@RestController
@RequestMapping("/fw/client")
@Validated
public class AppClientController {

    @Resource
    private ClientService clientService;

    @PostMapping("/create")
    @Operation(summary = "创建客户")
    public CommonResult<Long> createClient(@Valid @RequestBody AppClientSaveReqVO createReqVO) {
        return success(clientService.createClient(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "更新客户")
    public CommonResult<Boolean> updateClient(@Valid @RequestBody AppClientSaveReqVO updateReqVO) {
        clientService.updateClient(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除客户")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClient(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得客户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppClientDetailRespVO> getClient(@RequestParam("id") Long id) {
        ClientDO client = clientService.getClient(id);
        AppClientDetailRespVO detailRespVO = BeanUtils.toBean(client, AppClientDetailRespVO.class);

        detailRespVO.setAreaId(AreaUtils.getAreaIdList(client.getAreaId()));
        detailRespVO.setAreaName(AreaUtils.format(client.getAreaId()));

        return success(detailRespVO);
    }

    @GetMapping("/page")
    @Operation(summary = "获得客户分页")
    public CommonResult<PageResult<AppClientRespVO>> getClientPage(@Valid AppClientPageReqVO pageReqVO) {
        PageResult<ClientDO> pageResult = clientService.getClientPage(pageReqVO, getLoginUserId());
        return success(BeanUtils.toBean(pageResult, AppClientRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出客户 Excel")
    @ApiAccessLog(operateType = EXPORT)
    public void exportClientExcel(@Valid AppClientPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ClientDO> list = clientService.getClientPage(pageReqVO, getLoginUserId()).getList();
        // 导出 Excel
        ExcelUtils.write(response, "客户.xls", "数据", AppClientRespVO.class,
                        BeanUtils.toBean(list, AppClientRespVO.class));
    }

}