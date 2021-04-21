package ast;

public class ExpressionStatementAstNode extends AstNode {
    private AstNode expression;

    @Override
    public void acceptVisitorWithParent(Visitor visitor, AstNode parent) {
        visitor.visitExpressionStatementAstNode(this, parent);
    }

    public AstNode getExpression() {
        return expression;
    }

    public void setExpression(AstNode expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "ast.ExpressionStatementAstNode{" +
                "expression=" + expression +
                '}';
    }
}
