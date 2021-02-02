package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] findWithoutNull = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                findWithoutNull[count] = items[index];
                count++;
            }
        }
        return Arrays.copyOf(findWithoutNull, count);
    }

    public Item[] findByName(String key) {
        Item[] byKey = new Item[items.length];
        int size = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (key.equals(name.getName())) {
                byKey[size] = name;
                size++;
            }
        }
        byKey = Arrays.copyOf(byKey, size);
        return byKey;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }
}