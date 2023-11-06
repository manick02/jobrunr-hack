package org.example.MorseCodeParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.cobol.Cobol85Parser;
import org.cobol.morsecodeLexer;
import org.example.CobolLexerExample;

import java.io.InputStream;

public class MorseCodeAntlrExample {

    public static void main(String[] args) {
        try {
            InputStream inputStream = CobolLexerExample.class.getResourceAsStream("/morse_example.txt");
            Lexer lexer = new morsecodeLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            Cobol85Parser parser = new Cobol85Parser(tokenStream);
        } catch (Exception ex) {
            System.out.println("Hello how are you");
        }
    }


}
