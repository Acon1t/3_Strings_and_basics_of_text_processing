package src;

import java.util.Arrays;

public class StringAsObject {
    public static void task1() {
        System.out.println("Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем");
        String line = "a   b c       ddffdfdf  er  qwwqqw";
        System.out.println(line);
        int max = 0, count;
        for (int i = 0; i < line.toCharArray().length; i++) {
            count = 0;
            while (line.toCharArray()[i] == ' ') {
                count++;
                i++;
            }
            if (count > max) {
                max = count;
            }
        }
        System.out.println("Maximum number of spaces in text = " + max);
    }

    public static void task2() {
        System.out.println("В строке вставить после каждого символа 'a' символ 'b'.");
        String line = "a bba cccc df aaa";
        System.out.println(line);
        line = line.replaceAll("a", "ab");
        System.out.println(line);
    }

    public static void task3() {
        System.out.println("Проверить, является ли заданное слово палиндромом.");
        String line = "aba";
        System.out.println(line);
        StringBuffer t = new StringBuffer(line);
        t.reverse();
        String r = t.toString();
        if (line.equals(r)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }

    public static void task4() {
        System.out.println("С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.");
        String line = "информатика";
        System.out.println(line);
        String result = "";
        if (line.contains("т") && line.contains("о") && line.contains("р")) {

            result = result.concat(String.copyValueOf(line.toCharArray(), line.indexOf('т'), 1));
            result = result.concat(String.copyValueOf(line.toCharArray(), line.indexOf('о'), 1));
            result = result.concat(String.copyValueOf(line.toCharArray(), line.indexOf('р'), 1));
            result = result.concat(String.copyValueOf(line.toCharArray(), line.indexOf('т'), 1));
        }
        System.out.println(result);
    }

    public static void task5() {
        System.out.println("Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.");
        String line = "abv aa dddefwa";
        System.out.println(line);
        int count = 0;
        for (int i = 0; i < line.toCharArray().length; i++) {
            if (line.toCharArray()[i] == 'a') {
                count++;
            }
        }
        System.out.println("Number of “а” in text = " + count);
    }

    public static void task6() {
        System.out.println("Из заданной строки получить новую, повторив каждый символ дважды.");
        String line = "abv aa dddefwa";
        System.out.println(line);
        StringBuilder stringBuilder = new StringBuilder(line);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            result.append(stringBuilder.charAt(i));
            result.append(stringBuilder.charAt(i));
        }
        System.out.println(result);
    }

    public static void task7() {
        System.out.println(". Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено \"abc cde\n" +
                "def, то должно быть выведено abcdef.");
        String line = "abc cde def";
        System.out.println(line);
        line = line.replaceAll(" ", "");
        StringBuilder stringBuilder = new StringBuilder(line);
        for (int i = 0; i < stringBuilder.length(); i++) {
            char symbol = stringBuilder.charAt(i);
            for (int j = i + 1; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(j) == symbol) {
                    stringBuilder.deleteCharAt(j);
                }
            }
        }
        System.out.println(stringBuilder);
    }

    public static void task8() {
        System.out.println("Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых\n" +
                "длинных слов может быть несколько, не обрабатывать.");
        String line = "a bb vvvv aaaa";
        System.out.println(line);
        String[] words = line.split(" ");
        String maxWord = words[0];
        int word = words[0].length();
        int length;
        for (int i = 1; i < words.length; i++) {
            if ((length = words[i].length()) > word) {
                maxWord = words[i];
                word = length;
            }
        }
        System.out.println(maxWord);
    }

    public static void task9() {
        System.out.println("Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские\n" +
                "буквы.");
        String line = "abv aa dddefwa цуа AAA";
        System.out.println(line);
        int countLower = 0;
        int countUpper = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
                countLower++;
            }
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                countUpper++;
            }
        }
        System.out.println("Number of capital letters = " + countUpper);
        System.out.println("Number of lowercase letters = " + countLower);
    }

    public static void task10() {
        System.out.println("Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным\n" +
                "знаком. Определить количество предложений в строке X.\n");
        String line = "aaaaaa.dsfdsddsfsdfsdfsdf.a!a?";
        System.out.println(line);
        int countOfSentences = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '.' || line.charAt(i) == '!' || line.charAt(i) == '?') {
                countOfSentences++;
            }
        }
        System.out.println("Number of sentences in the text = " + countOfSentences);
    }
}
