package ASIris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	    /*  Задание 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
            Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
            Посчитать, сколько раз встречается каждое слово
	     */

        System.out.println("Задание 1:");
        //создаем загатовку массива
        ArrayList<String> arrayOfNames = new ArrayList<>(20);
        //заполняем массив
        fillArrayList(arrayOfNames);
        //вывод заполненного массива
        System.out.println("Исходный массив для поиска уникальных имен:\n" + arrayOfNames);
        //создаем новый массив для хранения уникальных слов
        HashMap<String,Integer> arrayOfNamesUnique;
        //подаем на вход метода поиска уникальных слов исходный массив, результат - новый массив
        arrayOfNamesUnique = createUniqueArrayOfNames(arrayOfNames);
        //вывод нового массива с уникальными словами
        System.out.println("Новый массив с уникальными словами:");
        for (Map.Entry<String,Integer> map : arrayOfNamesUnique.entrySet()) {
            System.out.println("Исходное слово - " + map.getKey() + " - количество упоминаний -  " + map.getValue());
        }

        /*  Задание 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
            телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
            а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
            может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны
            выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество,
            адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
            результатов проверки телефонного справочника
	     */

        System.out.println("\nЗадание 2:");
        //создаем объект класса
        Phonebook phonebook = new Phonebook();
        //заполняем телефонный справочник
        fillPhonebook(phonebook);
        //делаем запрос на поиск фамилии
        phonebook.get("Иванов");
    }

    private static void fillPhonebook(Phonebook phonebook) {
        phonebook.add("01234567", "Петров");
        phonebook.add("12345678", "Иванов");
        phonebook.add("23456789", "Сидоров");
        phonebook.add("34567890", "Кузнецов");
        phonebook.add("45678901", "Стрельцов");
        phonebook.add("56789012", "Иванов");
        phonebook.add("67890123", "Жуков");
        phonebook.add("78901234", "Корнеев");
        phonebook.add("89012345", "Поляков");
        phonebook.add("90123456", "Иванов");
    }

    private static HashMap<String, Integer> createUniqueArrayOfNames(ArrayList<String> arrayOfNames) {
        //создаем массив для возврата
        HashMap<String,Integer> hashMap = new HashMap<>();
        //вводим счетчик для учета повторов
        int count = 1;
        //циклом проходим по исходному массиву
        for (String word : arrayOfNames) {
            //проверяем наличие уже имеющегося ключа (повтор)
            if (hashMap.containsKey(word)) {
                //если уже есть, то увеличиваем счетчик
                count = hashMap.get(word) + 1;
            }
            //кладем каждое слово и количество упоминаний в словарь.
            //если повторов не было, то значение по ключу будет равно 1
            hashMap.put(word,count);
            //"обнуляем" счетчик повторов, так как мы его записали в значение по ключу
            count = 1;
        }
        //возвращаем полученный массив
        return hashMap;
    }


    private static void fillArrayList (ArrayList<String> list) {

        list.add("Саша"); list.add("Маша"); list.add("Паша"); list.add("Витя");
        list.add("Соня"); list.add("Иван"); list.add("Оля");  list.add("Саша");
        list.add("Коля"); list.add("Миша"); list.add("Ира");  list.add("Маша");
        list.add("Саша"); list.add("Паша"); list.add("Саша"); list.add("Оля");
    }
}
