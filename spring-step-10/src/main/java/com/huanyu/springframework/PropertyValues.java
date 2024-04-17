package com.huanyu.springframework;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PropertyValues
 * Package: com.huanyu.springframework
 * Description: 定义属性集合. 包含一个或多个 PropertyValue 对象的 Holder，通常包含对特定目标 bean 的一次更新。
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 15:10
 * @Version: 1.0
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
