package cn.iocoder.yudao.module.fw.dal.mysql.project;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.fw.dal.dataobject.project.ProjectDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.fw.controller.app.project.vo.*;

/**
 * fw-项目 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProjectMapper extends BaseMapperX<ProjectDO> {

    default PageResult<ProjectDO> selectPage(AppProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProjectDO>()
                .eqIfPresent(ProjectDO::getUserId, reqVO.getUserId())
                .likeIfPresent(ProjectDO::getName, reqVO.getName())
                .eqIfPresent(ProjectDO::getClientId, reqVO.getClientId())
                .eqIfPresent(ProjectDO::getType, reqVO.getType())
                .eqIfPresent(ProjectDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ProjectDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(ProjectDO::getEndTime, reqVO.getEndTime())
                .likeIfPresent(ProjectDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(ProjectDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProjectDO::getId));
    }

}