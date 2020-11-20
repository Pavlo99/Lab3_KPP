package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\t\tЗавдання 1.1");
        String text = ReadFromFile("Text.txt", false);

        System.out.println("\tПочатковий текст");
        System.out.println(text);
        String[] sentences = text.split("[\\.\\!\\?]");

        System.out.println();
        for (String str : sentences) {
            System.out.println(str);
        }

        System.out.println("\n\t\tЗавдання 1.2");
        text = ReadFromFile("Text.txt", true);

        System.out.println("\tПочатковий текст");
        System.out.println(text);
        sentences = text.split("[\\.\\!\\?]");

        int n = 1;
        System.out.println("Речення, які займають більше однієї стрічки:");
        for (String sentence : sentences) {
            if (sentence.indexOf("\n") > 0) {
                StringBuilder builderSentence = new StringBuilder(sentence);
                builderSentence.deleteCharAt(sentence.indexOf("\n"));
                sentence = builderSentence.toString();
                System.out.println(n + ") " + sentence);
                n++;
            }
        }

        System.out.println("\n\t\tЗавдання 1.3");
        text = ReadFromFile("FileOfPaths.txt", false);

        System.out.println("\tПочатковий текст");
        System.out.println(text+"\n");

        StringBuilder stringBuilderPath = new StringBuilder("");
        int currentChar = 0;
        char[] chars = text.toCharArray();
        while (currentChar < chars.length) {

            if(chars[currentChar] == ':' && stringBuilderPath.toString() != ""){
                stringBuilderPath.append(chars[currentChar]);
                currentChar++;
                continue;
            }
            if((chars[currentChar] == '\\')) {
                stringBuilderPath.append(chars[currentChar]);
                currentChar++;
                continue;
            }
            if(chars[currentChar] == '.' && stringBuilderPath.toString() != ""){
                System.out.println(stringBuilderPath);
                currentChar++;
                continue;
            }
            if (Character.isLetter(chars[currentChar]) && chars[currentChar] != ' ') {
                stringBuilderPath.append(chars[currentChar]);
            }
            else stringBuilderPath = new StringBuilder("");

            currentChar++;
        }


        System.out.println("\n\t\tЗавдання 2");

        text = ReadFromFile("Text.txt", false);
        Sentences sentences1 = new Sentences(text);
        sentences1.findAllInterrogativeSentences();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть довжину слова: ");
        sentences1.findAllWordsWithLength(scanner.nextInt());
    }

    static String ReadFromFile(String path, boolean withNewlineCharacter){
        String text = new String();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String str = myReader.nextLine();
                stringBuilder = withNewlineCharacter ? stringBuilder.append(str + "\n") : stringBuilder.append(str);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
        text = stringBuilder.toString();

        return text;
    }
}