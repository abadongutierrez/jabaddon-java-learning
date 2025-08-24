package com.jabaddon.learning.java.patterns.creational;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CacheManager {

    // Volatile ensures visibility of changes across threads
    private static volatile CacheManager instance;

    // Thread-safe map for cache storage
    private final ConcurrentMap<String, Object> cache;

    // Private constructor prevents external instantiation
    private CacheManager() {
        this.cache = new ConcurrentHashMap<>();
    }

    /**
     * Thread-safe singleton instance getter using double-checked locking
     * @return the singleton instance of CacheManager
     */
    public static CacheManager getInstance() {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager();
                }
            }
        }
        return instance;
    }

    /**
     * Stores a value in the cache with the given key
     * @param key the cache key
     * @param value the value to cache
     */
    public void put(String key, Object value) {
        if (key != null && value != null) {
            cache.put(key, value);
        }
    }

    /**
     * Retrieves a value from the cache by key
     * @param key the cache key
     * @return the cached value or null if not found
     */
    public Object get(String key) {
        return key != null ? cache.getOrDefault(key, null) : null;
    }

    /**
     * Retrieves a value from cache with type casting
     * @param key the cache key
     * @param type the expected type of the cached value
     * @param <T> the type parameter
     * @return the cached value cast to the specified type, or null if not found or wrong type
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        Object value = get(key);
        if (value != null && type.isInstance(value)) {
            return (T) value;
        }
        return null;
    }

    /**
     * Removes a value from the cache
     * @param key the cache key to remove
     * @return the removed value or null if not found
     */
    public Object remove(String key) {
        return key != null ? cache.remove(key) : null;
    }

    /**
     * Checks if a key exists in the cache
     * @param key the cache key to check
     * @return true if the key exists, false otherwise
     */
    public boolean containsKey(String key) {
        return key != null && cache.containsKey(key);
    }

    /**
     * Clears all entries from the cache
     */
    public void clear() {
        cache.clear();
    }

    /**
     * Returns the current size of the cache
     * @return the number of cached entries
     */
    public int size() {
        return cache.size();
    }

    /**
     * Checks if the cache is empty
     * @return true if the cache is empty, false otherwise
     */
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
