package parse;

import ast.AstNode;
import ast.CallAstNode;
import ast.ProgramAstNode;
import ast.ValueAstNode;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private final List<Token> tokens;
    private int current = 0;

    public ParserImpl(List<Token> tokens) {
        this.tokens = new ArrayList<>(tokens);
    }

    @Override
    public AstNode parse() {
        current = 0;

        ProgramAstNode programAstNode = new ProgramAstNode();

        while (current < tokens.size()) {
            programAstNode.addChild(walk());
        }

        return programAstNode;
    }

    private AstNode walk() {
        Token token = tokens.get(current);

        if (token.getType().equals(TokenType.NUMBER)) {
            current++;

            ValueAstNode valueAstNode = new ValueAstNode();

            valueAstNode.setValue(token.getValue());

            return valueAstNode;
        } else if (token.getType().equals(TokenType.STRING)) {
            current++;

            ValueAstNode valueAstNode = new ValueAstNode();

            valueAstNode.setValue(token.getValue());

            return valueAstNode;
        } else if (token.getType().equals(TokenType.PAREN) && token.getValue().equals('(')) {

            token = tokens.get(++current);

            CallAstNode callAstNode = new CallAstNode();

            callAstNode.setName((String) token.getValue());

            token = tokens.get(++current);

            while ((!token.getType().equals(TokenType.PAREN)) || (token.getType().equals(TokenType.PAREN) && ! token.getValue().equals(')'))) {

                callAstNode.addParam(walk());

                token = tokens.get(current);
            }

            current++;

            return callAstNode;
        }

        throw new RuntimeException("Token is not recognized " + token);
    }

}
