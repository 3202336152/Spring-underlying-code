## 实施步骤
1. `BeanFactory` 的定义由 `AbstractBeanFactory` 抽象类实现接口的 `getBean` 方法。
2. 而 `AbstractBeanFactory` 又继承了实现了 `SingletonBeanRegistry` 的 `DefaultSingletonBeanRegistry` 类。这样 `AbstractBeanFactory` 抽象类就具备了单例 Bean 的注册功能。
3. `AbstractBeanFactory` 中又定义了两个抽象方法：`getBeanDefinition(String beanName)`、`createBean(String beanName, BeanDefinition beanDefinition)` ，而这两个抽象方法分别由 `DefaultListableBeanFactory`、`AbstractAutowireCapableBeanFactory` 实现。
4. 最终 `DefaultListableBeanFactory` 还会继承抽象类 `AbstractAutowireCapableBeanFactory` 也就可以调用抽象类中的 `createBean` 方法了。
## 函数说明
**`BeanFactory`**：定义了一个能够管理和获取 Bean 实例的通用容器。
**`DefaultListableBeanFactory`**：是 BeanFactory 接口的一个具体实现。



