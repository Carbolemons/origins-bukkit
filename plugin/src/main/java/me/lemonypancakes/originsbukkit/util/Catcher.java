package me.lemonypancakes.originsbukkit.util;

import me.lemonypancakes.originsbukkit.api.data.type.Identifier;

import java.util.Map;

public class Catcher {

    public static boolean catchDuplicate(Object object0, Object object1) {
        return object0.toString()
                .equals(
                        object1.toString()
                );
    }

    public static boolean catchDuplicateFromMap(Map<?, ?> map, Object object) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            boolean equals = key.toString().equals(object.toString());

            if (equals) {
                return true;
            }
        }
        return false;
    }

    public static boolean catchDuplicateFromMap(Map<Identifier, ?> map, Identifier object) {
        for (Map.Entry<Identifier, ?> entry : map.entrySet()) {
            Identifier identifier = entry.getKey();
            boolean equals = identifier.toString().equals(object.toString());

            if (equals) {
                return true;
            }
        }
        return false;
    }

    public static <T> T getDuplicateFromMap(Map<?, ?> map, T t) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();

            if (key.toString()
                    .equals(
                            t.toString())) {
                return t;
            }
        }
        return null;
    }

    public static <T> T getDuplicateFromMap(Map<Identifier, T> map, Identifier object) {
        for (Map.Entry<Identifier, T> entry : map.entrySet()) {
            Object identifier = entry.getKey();

            if (identifier.toString()
                    .equals(
                            object.toString())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
