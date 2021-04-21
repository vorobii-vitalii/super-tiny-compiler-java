package parse;

public class Token {
    private final TokenType type;
    private final Object value;

    public Token(TokenType tokenType, Object value) {
        this.type = tokenType;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public TokenType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "parse.Token{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
