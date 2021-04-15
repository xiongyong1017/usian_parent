package com.usian.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 图片上传配置类
 *
 * @author : xy1201
 * @version 1.0
 * @date : 2021/4/15 16:50
 */
@Configuration
@Import(FdfsClientConfig.class)
//解决重读注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {

}
