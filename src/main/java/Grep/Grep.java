package Grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
    private boolean expr;
    private boolean isInvert;
    private boolean isIgnore;

    public Grep(boolean expr, boolean isInvert, boolean isIgnore) {
        this.expr = expr;
        this.isInvert = isInvert;
        this.isIgnore = isIgnore;
    }

    public ArrayList<String> options(String word, String input) {
        ArrayList<String> strings = new ArrayList<>();
        String selection = word;
        Pattern ignIsSelected;
        if (!expr) selection = Pattern.quote(word);
        if (isIgnore) ignIsSelected = Pattern.compile(selection, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        else ignIsSelected = Pattern.compile(selection);
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(input));
            Matcher matcher;
            String currentStr;
            while ((currentStr = reader.readLine()) != null) {
                matcher = ignIsSelected.matcher(currentStr);
                if (matcher.find() != isInvert) strings.add(currentStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public void printResult (ArrayList<String> result) {
            for (String string : result) {
                System.out.println(string);
            }
    }
}
