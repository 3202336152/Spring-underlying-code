package com.huanyu.springframework.context;

import com.huanyu.springframework.factory.ListableBeanFactory;


/**
 * ClassName: ApplicationContext
 * Package: com.huanyu.springframework.context
 * Description: 应用上下文接口，可以获取所有bean。
 * 应用上下文负责创建、配置和管理Bean实例。
 * 它读取配置元数据（如XML配置文件、Java注解或Java配置类），根据配置信息创建Bean，并将它们组织成一个松散耦合的应用程序。
 * 应用上下文还负责解析Bean之间的依赖关系，并将依赖的Bean自动注入到相应的位置。
 * @Author: 寰宇
 * @Create: 2024/4/14 15:13
 * @Version: 1.0
 */
public interface ApplicationContext extends ListableBeanFactory {
}
