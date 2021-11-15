package domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WordCounter implements CommandLineRunner {
    //@Value("${startString}")
    private String suggestionUrl = "Введите строку url сайта и нажмите Enter. Например:(www.simbirsoft.com)";
    @Autowired
    TextLoader textLoader;
    @Autowired
    CustomMatcher matcher;
    @Autowired
    CounterAndSorter sorter;
    public static void main(String[] args) {
        new SpringApplicationBuilder(WordCounter.class).run(args);

    }
    @Override
    public void run(String... args) throws Exception {
            sorter.groupAndSort(matcher.match(textLoader.loadPage(suggestionUrl)));
            System.out.println("Конец файла");
        }
}
