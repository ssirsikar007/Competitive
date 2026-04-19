package com.sirsikar.competitve.cache.lru;

import java.util.HashMap;

public class LRUCache<K,V> {
    private HashMap<K,Node<K,V>> map;
    private Node<K,V> head;
    private Node<K,V> tail;
    private int size;

    public LRUCache(int size) {
        this.map = new HashMap<>();
        this.head = new Node<>(null,null);
        this.tail = new Node<>(null,null);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size = size;
    }

    private void addToHead(Node<K,V> node) {
      node.setPrev(this.head);
      node.setNext(this.head.getNext());
      this.head.getNext().setPrev(node);
      this.head.setNext(node);
    }

    private void removeNode(Node<K,V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setPrev(null);
        node.setNext(null);
    }

    private void moveNodeToFront(Node<K,V> node) {
       removeNode(node);
       addToHead(node);
    }

    public V get(K key) {
        Node<K,V> node = map.get(key);
        if (node != null) {
            moveNodeToFront(node);
            return node.getValue();
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        Node<K,V> node = new Node<>(key,value);
        if (map.containsKey(key)) {
            Node<K,V> existing = map.get(key);
            existing.setValue(value);
            moveNodeToFront(existing);
            return;
        }
        addToHead(node);
        map.put(key,node);
        if (size < map.size()) {
            map.remove(this.tail.getPrev().getKey());
            removeNode(this.tail.getPrev());
        }
    }

    public void print() {
        Node<K,V> node = this.head.getNext();
        while (node != tail) {
            System.out.println(node.getKey() + "---"+ node.getValue());
            node = node.getNext();
        }
    }


}
