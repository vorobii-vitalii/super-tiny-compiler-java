package ast;

import java.util.ArrayList;
import java.util.List;

public class ProgramAstNode extends AstNode {
    private final List<AstNode> childNodes = new ArrayList<>();

    public List<AstNode> getChildNodes() {
        return childNodes;
    }

    public void addChild(AstNode astNode) {
        childNodes.add(astNode);
    }

    @Override
    public String toString() {
        return "ast.ProgramAstNode{" +
                "childNodes=" + childNodes +
                '}';
    }

    @Override
    public void acceptVisitorWithParent(Visitor visitor, AstNode parent) {
        visitor.visitProgramAstNode(this, parent);
    }
}
