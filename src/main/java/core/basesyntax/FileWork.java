package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] result = new String[]{};
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(Constants.MISSING_FILE_EXCEPTION);
        }
        if (!stringBuilder.isEmpty()) {
            String[] words = stringBuilder.toString().toLowerCase()
                    .split(Constants.REGEX_SEPARATOR);
            stringBuilder.setLength(Constants.EMPTY_STRING_BUILDER_LENGTH);
            for (String word : words) {
                if (word.charAt(Constants.INDEX_FOR_SEARCH) == Constants.FIRST_LETTER_FOR_SEARCH) {
                    stringBuilder.append(word).append(Constants.LIST_SEPARATOR);
                }
            }
            if (!stringBuilder.isEmpty()) {
                result = stringBuilder.toString().split(Constants.LIST_SEPARATOR);
                Arrays.sort(result);
                return result;
            }
        }
        return result;
    }
}