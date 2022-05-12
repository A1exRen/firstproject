package secfunct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnalyzerFunct {
    private static Pattern pattern; /* объекта класса Pattern*/
    private static Matcher matcher; /* Поисковик */
    private static final String delimiter = "*****"; /* разделители?? в новую строку*/

    public static void consandwowels(String inputText) {
        int vC = 0; /* Объявляем переменную кол-во гласных */
        int cC = 0; /* Объявляем переменную кол-во согласных */
        inputText = inputText.toLowerCase(); /*переводим текст в нижний регистр*/
        int l = inputText.length(); /* длина текста*/
        for (int i = 0; i < l; i++) {
            char c = inputText.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { /* Проверка на гласные (почему ругается на c?)*/
                vC = vC + 1;
            } else if ((c >= 'a' && c <= 'z')) { /* Проверка на cогласные */
                cC = cC + 1;

            }

        }
        System.out.println("vow:" + cC);
        System.out.println("cons:" + vC); /* Подумать над куда выводить*/
    }

    public static void numWords(String inputText) { /*Поиск кол-ва слов*/
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text"); /* Проверка на наличие текста*/
        } else {
            int i = 0;
            String regexp = "[a-zA-Z\\d]+(?=[,\\s\\.()\";:!?\\/\\-]*)"; /*регулярное выражение для слов (заменил выражение 0-9 на \d) Правильно ли? Разобраться!*/
            pattern = Pattern.compile(regexp); /*скомпилировали регулярное выражение для слов( что за серая рамка regex в коде у Вани? СПРОСИТЬ!)*/
            matcher = pattern.matcher(inputText); /*создали поисковик слов на основе рег. выражения pattern в тексте inputText*/
            while (matcher.find()) { /*Поиск кол-ва слов*/
                i++;/*Сумма кол-ва слов*/
            }
            System.out.println("There are: " + i + " words\n" + delimiter); /* Подумать над куда выводить*/
        }
    }

    public static void numberOfSymbols(String inputText) { /*Поиск кол-ва символов*/
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text"); /* Проверка на наличие текста*/
        } else {
            int i = 0;
            String regex = "[.]*"; /*выражение для любого символа( [.]* - означает любой символ)*/
            pattern = Pattern.compile(regex); /*скомпилировали рег выражение для любого символа*/
            matcher = pattern.matcher(inputText); /*поисковик символов на основе рег выражения pattern в тексте inputText*/
            while (matcher.find()) { /*Поиск кол-ва символов*/
                i++;/*Сумма кол-ва символов*/
            }
            System.out.println("There are: " + i + " symbols\n" + delimiter);
        }
    }

    public static void numberOfSentence(String inputText) {/*Поиск кол-ва предложений*/
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text"); /* Проверка на наличие текста*/
        } else {
            int i = 0;
            String regex = "(?:([.!?][\\s]*[A-Z])|([.!?][\\s]*$))"; /*выражение для любого предложения*/
            pattern = Pattern.compile(regex);/*скомпилировали рег выражение для любого предложения*/
            matcher = pattern.matcher(inputText);/*поисковик предложения на основе рег выражения pattern в тексте inputText*/

            while (matcher.find()) {/*Поиск кол-ва предложений*/
                i++;/*Сумма кол-ва предложений*/
            }
            System.out.println("There are: " + i + " Sentence(s)\n" + delimiter);

        }
    }

    public static void findWord(String inputText, String searchWord) { /*Поиск кол-ва определенных слов в тексте*/
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text"); /* Проверка на наличие текста*/
        } else {
            int i = 0;
            pattern = Pattern.compile(searchWord); /* скомпилировали шаблон по слову searchWord */
            matcher = pattern.matcher(inputText);/*поисковик предложения на шаблона*/

            while (matcher.find()) {/*Поиск кол-ва предложений*/
                i++;/*Сумма кол-ва предложений*/
            }
            System.out.println("There are: " + i + " matches\n" + delimiter);
        }
    }

    public static void sorttext(String inputText) {
        if (inputText == null || inputText.equals("")) {
            System.out.println("There is no text"); /* Проверка на наличие текста*/
        } else {
            Map<Integer, ArrayList<String>> counter = new HashMap<>();
            String[] wordList = inputText.split("\s"); /* Занесение текста в массив c разделением через регулярное выражение на пробел*/

            for (int i = 0; i < wordList.length; i++) {
                String s = wordList[i];
                Integer key = s.length();

                if (counter.containsKey(key)) {
                    counter.get(key).add(s);
                } else {
                    ArrayList<String> al = new ArrayList<String>();
                    al.add(s);
                    counter.put(key, al);
                }

            }
            for (Integer key : counter.keySet()) {
                System.out.printf("%s [%s] ", key, String.join(", ", counter.get(key)));
            }
        }
    }
}

