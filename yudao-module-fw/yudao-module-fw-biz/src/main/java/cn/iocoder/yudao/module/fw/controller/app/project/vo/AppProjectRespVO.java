package cn.iocoder.yudao.module.fw.controller.app.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "用户 APP - fw-项目 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppProjectRespVO {

    @Schema(description = "项目ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23778")
    @ExcelProperty("项目ID")
    private Long id;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "15921")
    @ExcelProperty("用户ID")
    private Long userId;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "客户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "8716")
    @ExcelProperty("客户ID")
    private Long clientId;

    @Schema(description = "项目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("项目类型")
    private String type;

    @Schema(description = "项目状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("项目状态")
    private String status;

    @Schema(description = "开始时间")
    @ExcelProperty("开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}