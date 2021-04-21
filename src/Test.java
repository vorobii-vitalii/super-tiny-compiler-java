import ast.AstNode;
import ast.CodeGeneratorVisitor;
import ast.TransformerVisitor;
import ast.Visitor;
import parse.Parser;
import parse.ParserImpl;
import parse.Token;
import parse.Tokenizer;
import parse.TokenizerImpl;
import transform.AstTransformer;
import transform.AstTransformerImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        Tokenizer tokenizer = new TokenizerImpl();

        String source =
                "(add 2 (subtract 4 2 (div 2 4)) 10) \n" +
                "(mult 2 4) \n" +
                "(div (div 2 4) 4) \n";

        System.out.println("Input source code: \n" + source);

        List<Token> fetchedTokens = tokenizer.tokenize(source);

        Parser parser = new ParserImpl(fetchedTokens);

        AstNode parsedAst = parser.parse();

        Visitor visitor = new TransformerVisitor();

        AstTransformer astTransformer = new AstTransformerImpl(visitor);

        AstNode transformedAst = astTransformer.transform(parsedAst);

        System.out.println("Transformed:");

        transformedAst.acceptVisitorWithParent(new CodeGeneratorVisitor(), null);
    }

}
