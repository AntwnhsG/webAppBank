package com.example.testinterview.api;

import lombok.Value;

@Value
public class KeyValue<K, V> {
    K key;
    V value;
}
