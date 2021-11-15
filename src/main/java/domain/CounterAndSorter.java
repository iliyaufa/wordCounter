package domain;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class CounterAndSorter {
    private List<Word> wordList;

    public CounterAndSorter(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void groupAndSort(List<Word> wordList){
        Map<String, Long> words = wordList.stream().collect(Collectors.groupingBy(Word::getValue, Collectors.counting()));
        words.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()).forEach(System.out::println);
    }
}
