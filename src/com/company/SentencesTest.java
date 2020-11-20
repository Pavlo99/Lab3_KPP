package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SentencesTest {

    @Test
    void findAllInterrogativeSentences() {
        String str1 = "How do you understand the meaning of this word?";
        String str2 = "A sentence is one of the basic units of a language.A simple sentence is a syntactic unit with predicative, semantic and" +
                "intonational completeness.How do you understand the meaning of this word?";

        Sentences sentences = new Sentences(str2);
        sentences.findAllInterrogativeSentences();

        Assert.assertEquals(sentences.getStringList().get(0).toString(),str1);
    }

    @Test
    void findAllWordsWithLength() {
        String str2 = "A sentence is one of the basic units of a language.A simple sentence is a syntactic unit with predicative, semantic and" +
                "intonational completeness.How do you understand the meaning of this word?";
        Sentences sentences = new Sentences(str2);
        sentences.findAllInterrogativeSentences();
        sentences.findAllWordsWithLength(10);

        Iterator<String> i = sentences.getWords().iterator();
        if (i.hasNext())
            Assert.assertEquals(i.next(), "understand");
    }
}