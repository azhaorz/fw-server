package cn.iocoder.yudao.module.fw.service.client;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.fw.controller.app.client.vo.*;
import cn.iocoder.yudao.module.fw.dal.dataobject.client.ClientDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 客户 Service 接口
 *
 * @author 芋道源码
 */
public interface ClientService {

    /**
     * 创建客户
     *
     * @param createReqVO 创建信息
     * @param userId 用户ID
     * @return 编号
     */
    Long createClient(@Valid AppClientSaveReqVO createReqVO, Long userId);

    /**
     * 更新客户
     *
     * @param updateReqVO 更新信息
     */
    void updateClient(@Valid AppClientSaveReqVO updateReqVO);

    /**
     * 删除客户
     *
     * @param id 编号
     */
    void deleteClient(Long id);

    /**
     * 获得客户
     *
     * @param id 编号
     * @return 客户
     */
    ClientDO getClient(Long id);

    /**
     * 获得客户分页
     *
     * @param pageReqVO 分页查询
     * @param userId 用户ID
     * @return 客户分页
     */
    PageResult<ClientDO> getClientPage(AppClientPageReqVO pageReqVO, Long userId);

}