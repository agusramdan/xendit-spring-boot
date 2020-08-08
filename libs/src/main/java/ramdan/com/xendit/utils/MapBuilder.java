package ramdan.com.xendit.utils;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@NonNull
public class MapBuilder<K, V> {
    private Map<K, V> map = new HashMap<K, V>();

    public static <K, V> MapBuilder<K, V> builder(Class<K> kClass) {
        return new MapBuilder<>();
    }

    public static <K, V> MapBuilder<K, V> builder(Class<K> kClass, Class<V> vClass) {
        return new MapBuilder<>();
    }

    public MapBuilder<K, V> put(K k, V v) {
        map.put(k, v);
        return this;
    }

    public Map<K, V> build(Map<K, V> target) {
        target.putAll(map);
        return target;
    }

    public Map<K, V> build() {
        return build(new HashMap<>());
    }
}
