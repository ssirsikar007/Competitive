package com.sirsikar.competitve.cache.lru;

public class LRUTester {
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache(3);
        lruCache.put(1, "Suraj");
        lruCache.put(2, "Likhitha");
        lruCache.put(3, "Suresh");
        lruCache.print();
        System.out.println(lruCache.get(1));
        lruCache.print();
    }
}
