# Lfu(Least Frequently Used)算法 --最近最不常用置换算法
移除最近时间内最少访问的节点，访问次数相同的比较访问时间的先后
```
public class Lfu<K, V> {

    private int capacity = 16;

    private HashMap<K, V> cache = new HashMap<>();

    private HashMap<K, AccessNumber> useCount = new HashMap<>();

    public Lfu() {
    }

    public Lfu(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        V v = cache.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                removeElement();
            }
            useCount.put(key, new AccessNumber(key, 1, System.nanoTime()));
        } else {
            addHitCount(key);
        }
        cache.put(key, value);
    }

    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            addHitCount(key);
            return value;
        }
        return null;
    }

    private void addHitCount(K key) {
        AccessNumber accessNumber = useCount.get(key);
        accessNumber.hitCount++;
        accessNumber.lastTime = System.nanoTime();
    }

    private void removeElement() {
        AccessNumber accessNumber = Collections.min(useCount.values());
        useCount.remove(accessNumber.key);
        cache.remove(accessNumber.key);
    }

    class AccessNumber implements Comparable<AccessNumber> {
        private K key;
        private int hitCount;
        private long lastTime;

        AccessNumber(K key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(AccessNumber o) {
            int compara = Integer.compare(this.hitCount, ((AccessNumber) o).hitCount);
            return compara == 0 ? Long.compare(this.lastTime, ((AccessNumber) o).lastTime) : compara;
        }

    }
}
```
