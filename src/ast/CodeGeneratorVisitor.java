package ast;

import java.util.List;

public class CodeGeneratorVisitor implements Visitor {
    @Override
    public void visitCallAstNode(CallAstNode callAstNode, AstNode parent) {
        AstNode callee = callAstNode.getCallee();

        callee.acceptVisitorWithParent(this, null);

        System.out.print('(');

        List<AstNode> params = callAstNode.getParams();

        int size = params.size();

        for (int i = 0; i < size; i++) {

            if (i != 0) {
                System.out.print(", ");
            }

            AstNode astNode = params.get(i);

            astNode.acceptVisitorWithParent(this, null);
        }

        System.out.print(')');
    }

    @Override
    public void visitProgramAstNode(ProgramAstNode programAstNode, AstNode parent) {
        List<AstNode> childNodes = programAstNode.getChildNodes();

        for (AstNode astNode : childNodes) {
            astNode.acceptVisitorWithParent(this, null);
            System.out.println();
        }

    }

    @Override
    public void visitValueAstNode(ValueAstNode valueAstNode, AstNode parent) {
        System.out.print(valueAstNode.getValue());
    }

    @Override
    public void visitExpressionStatementAstNode(ExpressionStatementAstNode expressionStatementAstNode, AstNode parent) {
        AstNode expression = expressionStatementAstNode.getExpression();

        expression.acceptVisitorWithParent(this, null);
        System.out.print(";");
    }

    @Override
    public void visitIdentifierAstNode(IdentifierAstNode identifierAstNode, AstNode parent) {
        System.out.print(identifierAstNode.getName());
    }
}
