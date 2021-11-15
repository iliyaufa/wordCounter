package domain;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Scanner;

@Component
public class TextLoader {

    public TextLoader() {
    }

    public String loadPage(String greetingString){
        System.out.println(greetingString);
        Scanner scanner = new Scanner(System.in);
        Document document = null;
        do {
            String urlString = scanner.nextLine();
            if (!urlString.startsWith("http"))
                urlString = "http://" + urlString;
            try {
                document = Jsoup.connect(urlString).get();
            } catch (IOException e) {
                System.out.println("Проверте правильность ввода url");
            }
        }while (document == null) ;
        String string = document.body().text();
        return string;
    }
}
