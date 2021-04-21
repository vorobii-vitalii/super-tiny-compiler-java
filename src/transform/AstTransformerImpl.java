package transform;

import ast.AstNode;
import ast.ProgramAstNode;
import ast.Visitor;

public class AstTransformerImpl implements AstTransformer {
    private final Visitor visitor;

    public AstTransformerImpl(Visitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public AstNode transform(AstNode inputAstNode) {
        ProgramAstNode programAstNode = new ProgramAstNode();

        inputAstNode.setContext(programAstNode.getChildNodes());

        inputAstNode.acceptVisitorWithParent(visitor, null);

        return programAstNode;
    }
}
