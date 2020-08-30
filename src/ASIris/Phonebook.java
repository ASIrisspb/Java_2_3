package ASIris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    //основное поле класса, хранящее запись телефона и фамилии
    public HashMap<String, String> records;

    //конструктор, создающий мапу, то есть поле класса
    public Phonebook() {
        this.records = new HashMap<>();
    }

    //метод добавления записи
    public void add(String phone, String surname) {
        records.put(phone, surname);
    }

    //метод получения списка телефонов по фамилии
    public void get(String surname) {
        //заготовка для вывода результата поиска
        ArrayList<String> resultOfSearch = new ArrayList<>();
        //проходим циклом по имеющемуся списку фамилий
        for (Map.Entry<String, String> record : records.entrySet()) {
            //если есть совпадение с заданной фамилией, то
            if (record.getValue().equals(surname)) {
                //кладем в результат поиска номер телефона
                resultOfSearch.add(record.getKey());
            }
        }
        //результаты выводим в консоль
        if (resultOfSearch.size() > 0) {
            System.out.println("В телефонном справочнике запрошенной фамилии соответствуют следующие номера:");
            for (String number : resultOfSearch) {
                System.out.println(number);
            }
        } else {
            System.out.println("Соответствий данной фамилии не найдено.");
        }
    }
}
