package com.xyzh.testLibrary.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 2016/5/21.
 */
public final class ValueHodler {
    private final Map<String, ValueWrapper> mValues = new HashMap<String, ValueWrapper>();

    public <T> ValueHodler putValue(String key, T value) {
        mValues.put(key, ValueWrapper.create(value));
        return this;
    }

    public <T> T getValue(String key) {
        ValueWrapper valueWrapper = mValues.get(key);
        if(valueWrapper != null) {
            return (T) valueWrapper.getValue();
        }
        return null;
    }

    public void remove(String key) {
        mValues.remove(key);
    }
}

final class ValueWrapper<T> {
    private T mValue;
    private ValueWrapper(T v){
        mValue = v;
    }

    public T getValue() {
        return mValue;
    }

    public void setValue(T value) {
        mValue = mValue;
    }

    public static final <E> ValueWrapper create(E v) {
        return new ValueWrapper<E>(v);
    }
}
