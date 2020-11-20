package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentences {
    private ArrayList<String> stringList = new ArrayList<>();
    private String text;
    private HashSet<String> words = new HashSet<>();

    public Sentences(String text) {
        this.text = text;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public HashSet<String> getWords() {
        return words;
    }

    public void setWords(HashSet<String> words) {
        this.words = words;
    }

    public void setStringList(ArrayList<String> stringList) {
        this.stringList = stringList;
    }

    public void addSentence(String sentence){
        stringList.add(sentence);
    }

    public void findAllInterrogativeSentences() {
        List<String> sentence = new ArrayList<>();
        Matcher matcher = Pattern.compile("([A-Z]([^?!.]|\\([^\\)]*\\))*[?])").matcher(text);
        while (matcher.find())
        {
            stringList.add(matcher.group());
            System.out.println(matcher.group());
        }
    }

    public void findAllWordsWithLength(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for (String str: stringList) {
            stringBuilder.append(str);
        }

        Matcher matcher = Pattern.compile("\\b\\w{"+ length +"}\\b").matcher(stringBuilder);
        while (matcher.find())
        {
            words.add(matcher.group());
            System.out.println(matcher.group());
        }
    }

    @Override
    public String toString() {
        return stringList.toString();
    }

}
