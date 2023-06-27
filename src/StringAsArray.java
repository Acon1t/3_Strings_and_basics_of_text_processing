package src;

import java.util.Arrays;


public class StringAsArray {


    public static void task1() {
        System.out.println("Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.");
        char[] line = new char[]{'a', 'a', 'a', 'B', 'b', 'C', 'c', 'c', 'c'};
        int count = 0;
        for (int i = 0; i < line.length - 1; i++) {
            if (line[i + 1] >= 'A' && line[i + 1] <= 'Z')
                count++;
        }
        System.out.println(Arrays.toString(line));
        char[] result = new char[line.length + count];
        for (int i = 0, j = 0; j < result.length; j++, i++) {
            if (line[i] >= 'A' && line[i] <= 'Z') {
                result[j] = '_';
                result[j + 1] = Character.toLowerCase(line[i]);
                j++;
            } else {
                result[j] = line[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void task2() {
        System.out.println("Замените в строке все вхождения 'word' на 'letter'.");
        String line = "word ewr word dsfwordff wordt";
        System.out.println(line);
        line = line.replaceAll("word", "letter");
        System.out.println("--------------");
        System.out.println(line);
    }

    public static void task3() {
        System.out.println("В строке найти количество цифр");
        String line = "word132 ewr4 word11 dsfwordff wordt56781";
        System.out.println(line);
        char[] array = line.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                count++;
            }
        }
        System.out.println("Number of digits = " + count);
    }

    public static void task4() {
        System.out.println("В строке найти количество чисел");
        String line = "word132 ewr4 word11 dsfwordff wordt56781";
        System.out.println(line);
        int count = 0;
        char[] array = line.toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (Character.isDigit(array[i])) {
                if (!Character.isDigit(array[i + 1])) {
                    count++;
                }
            }
        }
        if (Character.isDigit(array[array.length - 1])) {
            count++;
        }
        System.out.println("Amount of numbers = " + count);
    }

    public static void task5() {
        System.out.println("Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.\n" +
                "Крайние пробелы в строке удалить.");
        String line = "word132 ewr4 word11 dsfwordff  wordt    56781 ";
        System.out.println(line);
        line = line.replaceAll(" {2,}", " ").trim();
        System.out.println(line);
    }
}




