package cn.iocoder.yudao.module.tool.convert.test;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.tool.controller.admin.test.vo.TestDemoCreateReqVO;
import cn.iocoder.yudao.module.tool.controller.admin.test.vo.TestDemoExcelVO;
import cn.iocoder.yudao.module.tool.controller.admin.test.vo.TestDemoRespVO;
import cn.iocoder.yudao.module.tool.controller.admin.test.vo.TestDemoUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.tool.dal.dataobject.test.TestDemoDO;

@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
