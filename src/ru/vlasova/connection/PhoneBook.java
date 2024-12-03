package ru.vlasova.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook {
    private final Map<String, String> contacts; //карта имя - телефон

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    //добавление или обновление пары
    public String addContact(String name, String phone) {
        return contacts.put(name, phone);
    }

    //удаление по имени
    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

    //получение по имени
    public String getPhone(String name) {
        return contacts.get(name);
    }

    //проверка наличия имени в списке
    public boolean containsName(String name) {
        return contacts.containsKey(name);
    }

    //проверка наличия телефона в списке
    public boolean containsPhone(String phone) {
        return contacts.containsValue(phone);
    }

    //текущее количество контактов
    public int size() {
        return contacts.size();
    }

    //получение всех пар в виде массива
    public String[] getAllPairs() {
        return contacts.entrySet()
                .stream()
                .map(entry -> entry.getValue() + " - " + entry.getKey())
                .toArray(String[]::new);
    }

    //получение всех телефонов
    public String[] getAllPhones() {
        return contacts.values().toArray(new String[0]);
    }

    //получение всех имен
    public String[] getAllNames() {
        return contacts.keySet().toArray(new String[0]);
    }

    //поиск имен
    public String[] searchNamesByPrefix(String prefix) {
        return contacts.keySet()
                .stream()
                .filter(name -> name.startsWith(prefix))
                .toArray(String[]::new);
    }

    public String toString() {
        return contacts.entrySet()
                .stream()
                .map(entry -> entry.getValue() + " - " + entry.getKey())
                .collect(Collectors.joining("\n"));
    }
}
