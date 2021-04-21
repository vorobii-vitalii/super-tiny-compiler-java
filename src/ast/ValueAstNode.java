package ast;

public class ValueAstNode extends AstNode {
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ast.ValueAstNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public void acceptVisitorWithParent(Visitor visitor, AstNode parent) {
        visitor.visitValueAstNode(this, parent);
    }

}
