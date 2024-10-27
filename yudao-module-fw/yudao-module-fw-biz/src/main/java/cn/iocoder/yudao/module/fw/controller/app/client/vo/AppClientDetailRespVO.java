
package cn.iocoder.yudao.module.fw.controller.app.client.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Schema(description = "用户 APP - 客户详情 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppClientDetailRespVO {

    @Schema(description = "客户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "19507")
    @ExcelProperty("客户ID")
    private Long id;

    @Schema(description = "地区ID", example = "29679")
    @ExcelProperty("地区ID")
    private ArrayList<Integer> areaId;

    @Schema(description = "地区名称", example = "贵州省/贵阳市/南明区")
    @ExcelProperty("地区名称")
    private String areaName;

    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("客户名称")
    private String name;

    @Schema(description = "客户类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("客户类型")
    private String type;

    @Schema(description = "客户来源", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("客户来源")
    private String source;

    @Schema(description = "报价标准", requiredMode = Schema.RequiredMode.REQUIRED, example = "19909")
    @ExcelProperty("报价标准")
    private Integer quotePrice;

    @Schema(description = "合作状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("合作状态")
    private String cooperationStatus;

    @Schema(description = "联系人名称", example = "张三")
    @ExcelProperty("联系人名称")
    private String contactName;

    @Schema(description = "联系人电话")
    @ExcelProperty("联系人电话")
    private String contactMobile;

    @Schema(description = "联系人微信")
    @ExcelProperty("联系人微信")
    private String contactWx;

    @Schema(description = "联系人邮箱")
    @ExcelProperty("联系人邮箱")
    private String contactEmail;

    @Schema(description = "统一社会信用代码")
    @ExcelProperty("统一社会信用代码")
    private String uscc;

    @Schema(description = "地址")
    @ExcelProperty("地址")
    private String address;

    @Schema(description = "开户银行", example = "李四")
    @ExcelProperty("开户银行")
    private String bankName;

    @Schema(description = "银行账户", example = "17621")
    @ExcelProperty("银行账户")
    private String bankAccount;

    @Schema(description = "备注", example = "随便")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}