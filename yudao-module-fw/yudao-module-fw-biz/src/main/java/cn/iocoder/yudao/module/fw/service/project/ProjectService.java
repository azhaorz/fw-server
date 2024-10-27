package cn.iocoder.yudao.module.fw.service.project;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.fw.controller.app.project.vo.*;
import cn.iocoder.yudao.module.fw.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * fw-项目 Service 接口
 *
 * @author 芋道源码
 */
public interface ProjectService {

    /**
     * 创建fw-项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProject(@Valid AppProjectSaveReqVO createReqVO);

    /**
     * 更新fw-项目
     *
     * @param updateReqVO 更新信息
     */
    void updateProject(@Valid AppProjectSaveReqVO updateReqVO);

    /**
     * 删除fw-项目
     *
     * @param id 编号
     */
    void deleteProject(Long id);

    /**
     * 获得fw-项目
     *
     * @param id 编号
     * @return fw-项目
     */
    ProjectDO getProject(Long id);

    /**
     * 获得fw-项目分页
     *
     * @param pageReqVO 分页查询
     * @return fw-项目分页
     */
    PageResult<ProjectDO> getProjectPage(AppProjectPageReqVO pageReqVO);

}