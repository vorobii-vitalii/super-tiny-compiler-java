package ast;

public class IdentifierAstNode extends AstNode {
    private String name;

    @Override
    public void acceptVisitorWithParent(Visitor visitor, AstNode parent) {
        visitor.visitIdentifierAstNode(this, parent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ast.IdentifierAstNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
