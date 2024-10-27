package cn.iocoder.yudao.module.fw.controller.app.client.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "用户 APP - 客户分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppClientPageReqVO extends PageParam {

    @Schema(description = "地区ID", example = "29679")
    private Integer areaId;

    @Schema(description = "客户名称", example = "赵六")
    private String name;

    @Schema(description = "客户类型", example = "1")
    private String type;

    @Schema(description = "客户来源")
    private String source;

    @Schema(description = "报价标准", example = "19909")
    private Integer quotePrice;

    @Schema(description = "合作状态", example = "1")
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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}