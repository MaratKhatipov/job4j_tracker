package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Класс Item описывает модель заявления.
Поле id - это уникальный номер заявления.
Поле name содержит название заявления.
 */
public class Item  implements Comparable<Item> {
    private LocalDateTime created = LocalDateTime.now();

    private int id;
    private String name;
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(
            "dd-MMMM-EEEE-yyyy HH:mm");

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id) {
    this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Item {"
                +  "id = " + id
                +  ", name = '" + name + '\''
                + '}';
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.getId());
    }
}
