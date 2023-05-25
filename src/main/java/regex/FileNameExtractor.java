package regex;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameExtractor {

    public static void main(String[] args) {
        Path path = Paths.get("//api.qrcode-monkey.com/tmp/74e9adc877132da367f26cbb7eba19f3.eps");
        System.out.println(path.getFileName());

        String abc = "abc55def88ghi22qwerty";
        String[] split = abc.split("[0-9].");

        Arrays.stream(split).forEach(System.out::println);
    }

    public String extract(String str) {

        String result = null;

        Pattern pattern = Pattern.compile("[A-Za-z 0-9]*.eps");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            String fileName = matcher.group(1);
            System.out.println(fileName);
            result = fileName;
        } else {
            System.out.println("No file name found.");
        }
        return result;
    }

    public String extract1(String str) {

        String result = null;

        Pattern pattern = Pattern.compile("[0-9].");
        Matcher matcher = pattern.matcher(str);

        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println(matcher.group(i));
        }

        if (matcher.matches()) {
            String fileName = matcher.group(1);
            System.out.println(fileName);
            result = fileName;
        } else {
            System.out.println("No file name found.");
        }
        return result;
    }
}





