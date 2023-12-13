package main.Files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Filer {

    private Filer() {
    }

    public static ArrayList<String> ReadFileLines(String filePath) {
        ArrayList<String> listStrings = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Считывайте строки из файла до тех пор, пока не достигнете конца файла
            while ((line = reader.readLine()) != null) {
                listStrings.add(line); // Выводим каждую строку на экран или обрабатываем ее по вашему усмотрению
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStrings;
    }
    public static String getRandomString(String filePath){
        ArrayList<String> listStrings = ReadFileLines(filePath);
        Random random = new Random();
        int randomInd = random.nextInt(listStrings.size());
        String randomString = listStrings.get(randomInd);
        return randomString;
    }
}
