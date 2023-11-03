package org.example;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.cobol.Cobol85Lexer;
import org.cobol.Cobol85Parser;

import java.io.IOException;
import java.io.InputStream;

// Refered from
public class CobolLexerExample {

    public static void main(String[] args) {
        System.out.println("Antlr4 Example");
        try {
            /*
             * get the input file as an InputStream
             */
            InputStream inputStream = CobolLexerExample.class.getResourceAsStream("/example1.txt");
            /*
             * make Lexer
             */
            Lexer lexer = new Cobol85Lexer(CharStreams.fromStream(inputStream));
            /*
             * get a TokenStream on the Lexer
             */
            TokenStream tokenStream = new CommonTokenStream(lexer);
            /*
             * make a Parser on the token stream
             */
            Cobol85Parser parser = new Cobol85Parser(tokenStream);
            System.out.println(parser.toString());
            /*
             * get the top node of the AST. This corresponds to the topmost rule of equation.q4, "equation"
             */
            @SuppressWarnings("unused")
            Cobol85Parser.StartRuleContext startRuleContext = parser.startRule();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
