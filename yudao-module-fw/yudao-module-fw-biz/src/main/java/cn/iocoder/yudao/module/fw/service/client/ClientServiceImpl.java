package cn.iocoder.yudao.module.fw.service.client;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.fw.controller.app.client.vo.*;
import cn.iocoder.yudao.module.fw.dal.dataobject.client.ClientDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.fw.dal.mysql.client.ClientMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.fw.enums.ErrorCodeConstants.*;

/**
 * 客户 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientMapper clientMapper;

    @Override
    public Long createClient(AppClientSaveReqVO createReqVO, Long userId) {
        // 插入
        ClientDO client = BeanUtils.toBean(createReqVO, ClientDO.class).setUserId(userId);
        clientMapper.insert(client);
        // 返回
        return client.getId();
    }

    @Override
    public void updateClient(AppClientSaveReqVO updateReqVO) {
        // 校验存在
        validateClientExists(updateReqVO.getId());
        // 更新
        ClientDO updateObj = BeanUtils.toBean(updateReqVO, ClientDO.class);
        clientMapper.updateById(updateObj);
    }

    @Override
    public void deleteClient(Long id) {
        // 校验存在
        validateClientExists(id);
        // 删除
        clientMapper.deleteById(id);
    }

    private void validateClientExists(Long id) {
        if (clientMapper.selectById(id) == null) {
            throw exception(CLIENT_NOT_EXISTS);
        }
    }

    @Override
    public ClientDO getClient(Long id) {
        return clientMapper.selectById(id);
    }

    @Override
    public PageResult<ClientDO> getClientPage(AppClientPageReqVO pageReqVO, Long userId) {
        return clientMapper.selectPage(pageReqVO, userId);
    }

}