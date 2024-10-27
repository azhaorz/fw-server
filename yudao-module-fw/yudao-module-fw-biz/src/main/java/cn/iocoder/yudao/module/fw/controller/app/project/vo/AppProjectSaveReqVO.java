package cn.iocoder.yudao.module.fw.controller.app.project.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - fw-项目新增/修改 Request VO")
@Data
public class AppProjectSaveReqVO {

    @Schema(description = "项目ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "23778")
    private Long id;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "15921")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "项目名称不能为空")
    private String name;

    @Schema(description = "客户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "8716")
    @NotNull(message = "客户ID不能为空")
    private Long clientId;

    @Schema(description = "项目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "项目类型不能为空")
    private String type;

    @Schema(description = "项目状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "项目状态不能为空")
    private String status;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    private LocalDateTime endTime;

    @Schema(description = "备注", example = "你猜")
    private String remark;

}