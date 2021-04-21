package parse;

import parse.Token;
import parse.TokenType;
import parse.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class TokenizerImpl implements Tokenizer {
    @Override
    public List<Token> tokenize(String sourceCode) {

        if (sourceCode == null) {
            throw new RuntimeException("Source code is null");
        }

        final List<Token> fetchedTokens = new ArrayList<>();

        final int N = sourceCode.length();

        for (int i = 0; i < N; ) {

            char currentChar = sourceCode.charAt(i);

            if (currentChar == '(' || currentChar == ')') {
                fetchedTokens.add(new Token(TokenType.PAREN, currentChar));
                i++;
            } else if (Character.isSpaceChar(currentChar) || Character.isWhitespace(currentChar)) {
                i++;
            } else if (Character.isDigit(currentChar)) {
                StringBuilder stringBuilder = new StringBuilder();

                while (Character.isDigit(currentChar)) {
                    stringBuilder.append(currentChar);
                    currentChar = sourceCode.charAt(++i);
                }

                fetchedTokens.add(
                        new Token(TokenType.NUMBER, stringBuilder.toString()));

            } else if (currentChar == '"') {
                StringBuilder stringBuilder = new StringBuilder();

                currentChar = sourceCode.charAt(++i);

                while (currentChar != '"') {
                    stringBuilder.append(currentChar);
                    currentChar = sourceCode.charAt(++i);
                }

                currentChar = sourceCode.charAt(++i);

                fetchedTokens.add(
                        new Token(TokenType.STRING, stringBuilder.toString())
                );
            } else if (Character.isLetter(currentChar)) {
                StringBuilder stringBuilder = new StringBuilder();

                while (Character.isLetter(currentChar)) {
                    stringBuilder.append(currentChar);
                    currentChar = sourceCode.charAt(++i);
                }

                fetchedTokens.add(new Token(TokenType.NAME, stringBuilder.toString()));
            }
            else {
                throw new RuntimeException("Error during tokenize stage, received - " + currentChar);
            }
        }

        return fetchedTokens;
    }
}
