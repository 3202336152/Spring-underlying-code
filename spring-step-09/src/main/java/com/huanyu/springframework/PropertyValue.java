package com.huanyu.springframework;

/**
 * ClassName: PropertyValue
 * Package: com.huanyu.springframework
 * Description: 定义属性值 对象保存单个 bean 属性的信息和值。
 * 在这里使用对象，而不是仅仅将所有属性存储在按属性名称键控的映射中，可以提供更大的灵活性，并能够以优化的方式处理索引属性等。
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 15:08
 * @Version: 1.0
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
