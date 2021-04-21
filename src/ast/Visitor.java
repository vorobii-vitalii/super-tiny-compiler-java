package ast;

public interface Visitor {
    void visitCallAstNode(CallAstNode callAstNode, AstNode parent);
    void visitProgramAstNode(ProgramAstNode programAstNode, AstNode parent);
    void visitValueAstNode(ValueAstNode valueAstNode, AstNode parent);
    void visitExpressionStatementAstNode(ExpressionStatementAstNode expressionStatementAstNode, AstNode parent);
    void visitIdentifierAstNode(IdentifierAstNode identifierAstNode, AstNode parent);
}
