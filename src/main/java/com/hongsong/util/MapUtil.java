package com.hongsong.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工具类
 *
 * @Author: jht
 * @Date: 2023/03/07 14:48
 */
public class MapUtil {
    private MapUtil() {
    }

    /**
     * @describe: 生成String,Object类型的map
     * @Author: jht
     * @param key 键
     * @param value 值
     * @Date: 2023/3/7 14:50
     */
    public static Map<String, Object> getMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
