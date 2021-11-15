package domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class CustomMatcher {

    private String regexString;

    public CustomMatcher() {
        this.regexString = "[A-zА-я]+";
    }

    public List<Word> match(String str){
        List<Word> wordList = new ArrayList<>();
        Pattern pat = Pattern.compile(regexString);//с помощью этого паттерна извлекаем слова из строк и сохраняем в динамический массив
        Matcher mat = pat.matcher(str);
        while ( mat.find())
            wordList.add(new Word(mat.group()));
        return wordList;
    }
}
