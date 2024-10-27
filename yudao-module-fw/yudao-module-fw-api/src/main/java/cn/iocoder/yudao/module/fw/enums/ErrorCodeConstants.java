package cn.iocoder.yudao.module.fw.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    // ========== FW 客户（1-050-100-000） ==========
    ErrorCode CLIENT_NOT_EXISTS = new ErrorCode(1_050_100_000, "客户不存在");
}
