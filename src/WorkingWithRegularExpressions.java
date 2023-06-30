package src;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkingWithRegularExpressions {
    public static void task1() {
        System.out.println("Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных\n" +
                "операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;\n" +
                "отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по\n" +
                "алфавиту.");
        String line = "Aaaa aaaaaaaabbbbaaaaaaaaaa aaabaaaa aaaaaaaabbaaaaaa.Bb bbbbbbbb b bb.\n" +
                "Ccc ccc ccccccbccccc.\n" +
                "Btt tttttttttt ttttttttttt ttttttttttttttttttttttt.As ssss ssssssssssss b sssssssssss sssssss ssss sssss.Aaa saasa.";
        System.out.println("-------------------------------------");
        System.out.println("Original text");
        System.out.println("---------------------------------------------");
        System.out.println(line);
        System.out.println("----------------------------------------");
        System.out.println("Enter a number from 1 to 3 and press <Enter>:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number) {
            case 1:
                bySentenceCount(line);
                break;
            case 2:
                byWordLength(line);
                break;
            case 3:
                System.out.println("Enter character");
                String symbol = scan.next();
                byLexemeCount(line, symbol);
                break;
        }
    }

    //used in task 1
    public static void bySentenceCount(String text) {
        String[] paragraphs = text.split("\n");
        Arrays.sort(paragraphs, (paragraph1, paragraph2) ->
                paragraph1.split("[!?.:]+").length >= paragraph2.split("[!?.:]+").length ? 1 : -1);
        for (String paragraph : paragraphs) {
            System.out.println(paragraph);
        }
    }

    //used in task 1
    public static void byWordLength(String text) {
        String[] paragraphs = text.split("\n");
        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = paragraphs[i].split("[.!?]");
            for (int j = 0; j < sentences.length; j++) {
                String[] words = sentences[j].split(" ");
                Arrays.sort(words, Comparator.comparingInt(String::length));
                String result = String.join(" ", words);
                System.out.println(result);
            }
        }
    }

    //used in task 1
    public static void byLexemeCount(String text, String symbol) {
        String[] paragraphs = text.split("\n");
        for (int i = 0; i < paragraphs.length; i++) {
            String[] sentences = paragraphs[i].split("[.!?]");
            for (int j = 0; j < sentences.length; j++) {
                String[] words = sentences[j].split(" ");
                for (int k = words.length - 1; k >= 0; k--) {
                    for (int m = 0; m < k; m++) {
                        int countRight = 0;
                        int countLeft = 0;
                        for (int n = 0; n < words[m].length(); n++) {
                            if (String.valueOf(words[m].charAt(n)).compareToIgnoreCase(symbol) == 0) {
                                countLeft++;
                            }
                        }
                        for (int n = 0; n < words[m + 1].length(); n++) {
                            if (String.valueOf(words[m + 1].charAt(n)).compareToIgnoreCase(symbol) == 0) {
                                countRight++;
                            }
                        }
                        if (countLeft < countRight) {
                            String tmp = words[m];
                            words[m] = words[m + 1];
                            words[m + 1] = tmp;
                        } else if (countLeft == countRight) {
                            String[] forCompare = {words[m], words[m + 1]};
                            Arrays.sort(forCompare);
                            words[m] = forCompare[0];
                            words[m + 1] = forCompare[1];
                        }
                    }
                }
                for (int m = 0; m < words.length; m++) {
                    System.out.print(words[m] + " ");
                }
                System.out.print("\b. ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void task2() {
        System.out.println("Дана строка, содержащая следующий текст (xml-документ).Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий\n" +
                "тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи\n" +
                "нельзя.");
        String line = "<notes>\n" +
                " <note id = \"1\">\n" +
                "  <to>Вася</to>\n" +
                "  <from>Света</from>\n" +
                "  <heading>Напоминание</heading>\n" +
                "  <body>Позвони мне завтра!</body>\n" +
                " </note>\n" +
                " <note id = \"2\">\n" +
                "  <to>Петя</to>\n" +
                "  <from>Маша</from>\n" +
                "  <heading>Важное напоминание</heading>\n" +
                "  <body/>\n" +
                " </note>\n" +
                "</notes>";
        Pattern pattern = Pattern.compile("</?.+?>");
        Matcher matcher = pattern.matcher(line);
        boolean flagOpen = true;
        boolean flagClose = true;
        int tagEnd = 0, tagStart = 0;
        while (matcher.find()) {
            String temp = line.substring(matcher.start() + 1, matcher.start() + 2);
            String tempEmpty = line.substring(matcher.end() - 2, matcher.end() - 1);
            String tag = line.substring(matcher.start(), matcher.end());
            if (!temp.equals("/") && !tempEmpty.equals("/")) {
                System.out.println("Opening tag = " + tag);
                flagOpen = false;
                tagStart = matcher.end();
            } else {
                if (tempEmpty.equals("/")) {
                    System.out.println("Tag without body = ");
                } else {
                    flagClose = false;
                    tagEnd = matcher.start();
                    System.out.println("Closing tag = " + tag);
                }
            }
            if (!flagClose && !flagOpen) {
                if (tagStart < tagEnd) {
                    String tagContent = line.substring(tagStart, tagEnd);
                    flagOpen = true;
                    flagClose = true;
                    System.out.println("Tag content = " + tagContent);
                }
            }
        }
    }
}
