package com.baig.translate;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MorseCodeTranslatorTest
{
    @Test
    public void testValidEnglishToMorseCode(){
        MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", morseCodeTranslator.convertToMorse("hello world"));
    }

    @Test
    public void testValidEnglishToMorseCode2(){
        MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
        assertEquals(".... . .-.. .-.. --- / .--- --- . / -... .-.. --- --. --. ...", morseCodeTranslator.convertToMorse("hello joe bloggs"));
    }

    @Test
    public void testValidMorseCodeToEnglish(){
        MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
        assertEquals("hello world", morseCodeTranslator.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    public void testValidMorseCodeToEnglish2(){
        MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
        assertEquals("hello joe bloggs", morseCodeTranslator.convertToEnglish(".... . .-.. .-.. --- / .--- --- . / -... .-.. --- --. --. ..."));
    }
}

