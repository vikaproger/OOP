package task15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class task151 {
    public static void main(String[] args) throws IOException {
        URL yahoo = new URL("http://www.yahoo.com/");           //создаем экземпляр калсса URL
        URLConnection yc = yahoo.openConnection();                      // устанавливаем связь
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));     //открываем поток для четния
        String inputLine;
        while ((inputLine = in.readLine()) != null) {           //читаем
            System.out.println(inputLine);              //выводим на консоль
        }
        in.close();         //закрываем файл
    }
}
