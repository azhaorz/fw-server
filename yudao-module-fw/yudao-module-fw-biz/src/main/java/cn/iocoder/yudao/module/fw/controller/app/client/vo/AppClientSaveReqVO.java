package cn.iocoder.yudao.module.fw.controller.app.client.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "用户 APP - 客户新增/修改 Request VO")
@Data
public class AppClientSaveReqVO {

    @Schema(description = "客户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19507")
    private Long id;

    @Schema(description = "地区ID", example = "29679")
    private Integer areaId;

    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "客户名称不能为空")
    private String name;

    @Schema(description = "客户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "客户类型不能为空")
    private String type;

    @Schema(description = "客户来源", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "客户来源不能为空")
    private String source;

    @Schema(description = "报价标准", requiredMode = Schema.RequiredMode.REQUIRED, example = "19909")
    @NotNull(message = "报价标准不能为空")
    private Integer quotePrice;

    @Schema(description = "合作状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "合作状态不能为空")
    private String cooperationStatus;

    @Schema(description = "联系人名称", example = "张三")
    private String contactName;

    @Schema(description = "联系人电话")
    private String contactMobile;

    @Schema(description = "联系人微信")
    private String contactWx;

    @Schema(description = "联系人邮箱")
    private String contactEmail;

    @Schema(description = "统一社会信用代码")
    private String uscc;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "开户银行", example = "李四")
    private String bankName;

    @Schema(description = "银行账户", example = "17621")
    private String bankAccount;

    @Schema(description = "备注", example = "随便")
    private String remark;

}