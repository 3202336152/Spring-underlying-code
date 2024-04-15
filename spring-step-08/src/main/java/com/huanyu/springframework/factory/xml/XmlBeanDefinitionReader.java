package com.huanyu.springframework.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.PropertyValue;
import com.huanyu.springframework.core.io.Resource;
import com.huanyu.springframework.core.io.ResourceLoader;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.BeanReference;
import com.huanyu.springframework.factory.support.AbstractBeanDefinitionReader;
import com.huanyu.springframework.factory.support.BeanDefinitionRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: XmlBeanDefinitionReader
 * Package: com.huanyu.springframework.factory.xml
 * Description: 具体的Bean定义读取器 XmlBeanDefinitionReader 对 XML 文件的解析
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:58
 * @Version: 1.0
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    /**
     * 从资源中加载Bean定义。
     *
     * @param resource 要加载的资源
     * @throws BeansException 如果在解析XML文档时出现IOException或ClassNotFoundException，则抛出BeansException异常
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            // 通过资源获取输入流
            try (InputStream inputStream = resource.getInputStream()) {
                // 调用具体的加载方法
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            // 如果出现异常，将异常封装为BeansException并抛出
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    /**
     * 从多个资源中加载Bean定义。
     *
     * @param resources 要加载的多个资源
     * @throws BeansException 如果在解析XML文档时出现IOException或ClassNotFoundException，则抛出BeansException异常
     */
    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    /**
     * 从指定位置的资源中加载Bean定义。
     *
     * @param location 资源的位置
     * @throws BeansException 如果在解析XML文档时出现IOException或ClassNotFoundException，则抛出BeansException异常
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        // 获取资源加载器
        ResourceLoader resourceLoader = getResourceLoader();
        // 根据指定位置获取资源
        Resource resource = resourceLoader.getResource(location);
        // 加载Bean定义
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 根据输入流解析并加载Bean定义。
     * 增加对init-method、destroy-method的读取。
     * @param inputStream 输入流，包含XML文档数据
     * @throws ClassNotFoundException 如果在解析过程中找不到类定义，则抛出ClassNotFoundException异常
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // 使用XmlUtil工具类读取XML文档并返回Document对象
        Document doc = XmlUtil.readXML(inputStream);
        // 获取根元素
        Element root = doc.getDocumentElement();
        // 获取根元素的所有子节点
        NodeList childNodes = root.getChildNodes();
        // 遍历子节点
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断节点类型是否为元素节点
            if (!(childNodes.item(i) instanceof Element)) continue;
            // 判断元素节点是否为<bean>标签
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // 解析<bean>标签
            Element bean = (Element) childNodes.item(i);
            // 获取<bean>标签的id、name和class属性值
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //增加对init-method、destroy-method的读取
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            // 根据class属性值获取对应的Class对象
            Class<?> clazz = Class.forName(className);
            // 根据id或name确定bean的名称，优先级：id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            // 如果名称为空，则使用类名的首字母小写作为bean的名称
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 创建BeanDefinition对象，并使用clazz作为bean的类型
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            //额外设置到beanDefinition中
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            // 解析<bean>标签下的<property>子标签，读取属性信息并填充到BeanDefinition中
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                // 判断子节点类型是否为元素节点
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                // 判断元素节点是否为<property>标签
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                // 解析<property>标签
                Element property = (Element) bean.getChildNodes().item(j);
                // 获取<property>标签的name、value和ref属性值
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 根据ref属性判断属性值是引用对象还是普通值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建PropertyValue对象，存储属性名称和属性值
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                // 将PropertyValue对象添加到BeanDefinition的属性值列表中
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }

            // 检查是否已经存在同名的BeanDefinition，如果是则抛出异常
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }

            // 注册BeanDefinition到BeanDefinitionRegistry中
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }


}
