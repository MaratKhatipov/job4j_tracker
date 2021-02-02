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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] byKey = new Item[items.length];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (key.equals(name.getName())) {
                byKey[count] = name;
                count++;
            }
        }
        byKey = Arrays.copyOf(byKey, count);
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

/*
Валидация была добавлена ранее: if (index != -1)
 */
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
/*
Валидация была добавлена ранее: if (index != -1)
*/

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int distPos = index;
        int length = size - index;
        if (index != -1) {
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}