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
            System.out.println("Исходное слово - " + map.getKey() + " - встретилось " + map.getValue() + " раз(а).");
        }
    }

    private static HashMap<String, Integer> createUniqueArrayOfNames(ArrayList<String> arrayOfNames) {
        //создаем массив для возврата
        HashMap<String,Integer> hashMap = new HashMap<>();
        //вводим счетчик для учета повторов
        int count = 1;
        //циклом проходим по исходному массиву
        for (String word : arrayOfNames) {
            //получаем множество уже имеющихся ключей, чтобы проверить повторы
            for (String entry : hashMap.keySet()) {
                //если очередное слово из исходного списка уже встречалось, то значит такой ключ уже есть
                if (entry.equals(word)) {
                    //тогда мы берем значение по этому ключу, которое хранит как раз повторы и увеличиваем на 1
                    count = hashMap.get(entry) + 1;
                }
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

        list.add("Саша");
        list.add("Маша");
        list.add("Паша");
        list.add("Витя");
        list.add("Соня");
        list.add("Иван");
        list.add("Оля");
        list.add("Саша");
        list.add("Коля");
        list.add("Миша");
        list.add("Ира");
        list.add("Маша");
        list.add("Саша");
        list.add("Паша");
        list.add("Саша");
        list.add("Оля");

    }
}
