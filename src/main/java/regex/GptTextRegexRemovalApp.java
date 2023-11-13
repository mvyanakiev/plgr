package regex;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GptTextRegexRemovalApp {


    // TODO ChatGPT code - check and fix

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Въвеждане на текст
        System.out.println("Въведете текст:");
        String inputText = scanner.nextLine();

        // Въведете регулярния израз за премахване
        System.out.println("Въведете регулярен израз за премахване:");
        String regexPattern = scanner.nextLine();

        // Използване на регулярния израз за премахване на фрагментите от текста
        String resultText = removeTextUsingRegex(inputText, regexPattern);

        // Извеждане на резултата
        System.out.println("Резултат след премахване на фрагментите:");
        System.out.println(resultText);
    }

    private static String removeTextUsingRegex(String inputText, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(inputText);

        // Премахване на съвпаденията с регулярния израз
        String resultText = matcher.replaceAll("");

        return resultText;
    }
}
