package org.example.SimpleArithmeticExpression;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.cobol.*;

// Simple Arithmetic expression  - https://stackoverflow.com/questions/23092081/antlr4-visitor-pattern-on-simple-arithmetic-example
public class SimpleExpressionVistitor extends SimpleArithmeticExpressionBaseVisitor<Integer> {


    @Override
    public Integer visitStart(SimpleArithmeticExpressionParser.StartContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Integer visitOpExpr(SimpleArithmeticExpressionParser.OpExprContext ctx) {
        int left = visit(ctx.left);
        int right = visit(ctx.right);
        String op = ctx.op.getText();
        switch (op.charAt(0)) {
            case '*': return left * right;
            case '/': return left / right;
            case '+': return left + right;
            case '-': return left - right;
            default: throw new IllegalArgumentException("Unknown operator " + op);
        }

    }

    @Override
    public Integer visitAtomExpr(SimpleArithmeticExpressionParser.AtomExprContext ctx) {
        return Integer.valueOf(ctx.getText());
    }

    @Override
    public Integer visitParenExpr(SimpleArithmeticExpressionParser.ParenExprContext ctx) {
         return this.visit(ctx.expr());
    }
    public static void main(String[] args) {
        String expression = "2 * (3 + 4)";
        SimpleArithmeticExpressionLexer lexer = new SimpleArithmeticExpressionLexer(CharStreams.fromString(expression));
        SimpleArithmeticExpressionParser parser = new SimpleArithmeticExpressionParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        Integer answer = new SimpleExpressionVistitor().visit(tree);
        System.out.printf("%s = %s\n", expression, answer);
    }

}
