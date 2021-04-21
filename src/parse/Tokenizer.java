package parse;

import java.util.List;

public interface Tokenizer {
    List<Token> tokenize(String t);
}
