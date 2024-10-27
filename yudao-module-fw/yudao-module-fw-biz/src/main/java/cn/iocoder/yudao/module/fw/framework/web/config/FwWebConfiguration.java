package cn.iocoder.yudao.module.fw.framework.web.config;

import cn.iocoder.yudao.framework.swagger.config.YudaoSwaggerAutoConfiguration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fw 模块的 web 组件的 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class FwWebConfiguration {

    /**
     * fw 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi fwGroupedOpenApi() {
        return YudaoSwaggerAutoConfiguration.buildGroupedOpenApi("fw");
    }

}
