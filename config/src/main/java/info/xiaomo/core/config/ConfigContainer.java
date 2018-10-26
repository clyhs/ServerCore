/**
 * 创建日期:  2017年08月21日 17:39
 * 创建作者:  杨 强  <281455776@qq.com>
 */
package info.xiaomo.core.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置容器
 *
 * @author YangQiang
 */
@Data
public class ConfigContainer<T> implements IConfigContainer {
    private Map<Object, T> configMap = new HashMap<>(10);
    private List<T> configList = new ArrayList<>();

    @Override
    public T getConfig(Object key) {
        return configMap.get(key);
    }

    @Override
    public List<T> getList() {
        return configList;
    }

	public Map<Object, T> getConfigMap() {
		return configMap;
	}

	public void setConfigMap(Map<Object, T> configMap) {
		this.configMap = configMap;
	}

	public List<T> getConfigList() {
		return configList;
	}

	public void setConfigList(List<T> configList) {
		this.configList = configList;
	}
    
    
}
