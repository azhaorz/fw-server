package cn.iocoder.yudao.module.fw.dal.dataobject.client;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 客户 DO
 *
 * @author 芋道源码
 */
@TableName("fw_client")
@KeySequence("fw_client_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDO extends BaseDO {

    /**
     * 客户ID
     */
    @TableId
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 地区ID
     */
    private Integer areaId;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 客户类型
     */
    private String type;
    /**
     * 客户来源
     */
    private String source;
    /**
     * 报价标准
     */
    private Integer quotePrice;
    /**
     * 合作状态
     */
    private String cooperationStatus;
    /**
     * 联系人名称
     */
    private String contactName;
    /**
     * 联系人电话
     */
    private String contactMobile;
    /**
     * 联系人微信
     */
    private String contactWx;
    /**
     * 联系人邮箱
     */
    private String contactEmail;
    /**
     * 统一社会信用代码
     */
    private String uscc;
    /**
     * 地址
     */
    private String address;
    /**
     * 开户银行
     */
    private String bankName;
    /**
     * 银行账户
     */
    private String bankAccount;
    /**
     * 备注
     */
    private String remark;

}