package cn.iocoder.yudao.module.fw.dal.mysql.client;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.fw.dal.dataobject.client.ClientDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.fw.controller.app.client.vo.*;

/**
 * 客户 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ClientMapper extends BaseMapperX<ClientDO> {

    default PageResult<ClientDO> selectPage(AppClientPageReqVO reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ClientDO>()
                .eq(ClientDO::getUserId, userId)
                .eqIfPresent(ClientDO::getAreaId, reqVO.getAreaId())
                .likeIfPresent(ClientDO::getName, reqVO.getName())
                .eqIfPresent(ClientDO::getType, reqVO.getType())
                .eqIfPresent(ClientDO::getSource, reqVO.getSource())
                .eqIfPresent(ClientDO::getQuotePrice, reqVO.getQuotePrice())
                .eqIfPresent(ClientDO::getCooperationStatus, reqVO.getCooperationStatus())
                .likeIfPresent(ClientDO::getContactName, reqVO.getContactName())
                .likeIfPresent(ClientDO::getContactMobile, reqVO.getContactMobile())
                .likeIfPresent(ClientDO::getContactWx, reqVO.getContactWx())
                .likeIfPresent(ClientDO::getContactEmail, reqVO.getContactEmail())
                .likeIfPresent(ClientDO::getUscc, reqVO.getUscc())
                .likeIfPresent(ClientDO::getAddress, reqVO.getAddress())
                .likeIfPresent(ClientDO::getBankName, reqVO.getBankName())
                .likeIfPresent(ClientDO::getBankAccount, reqVO.getBankAccount())
                .likeIfPresent(ClientDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ClientDO::getCreateTime, reqVO.getCreateTime())
                .last("ORDER BY FIELD(cooperation_status, 'collaborating', 'completed_not_collaborate'), id DESC"));
    }

}