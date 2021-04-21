package ast;

import java.util.List;

public class TransformerVisitor implements Visitor {

    @Override
    public void visitCallAstNode(CallAstNode callAstNode, AstNode parent) {
        CallAstNode callAstNodeExpression = new CallAstNode();

        IdentifierAstNode identifierAstNode = new IdentifierAstNode();

        identifierAstNode.setName(callAstNode.getName());

        callAstNodeExpression.setCallee(identifierAstNode);

        callAstNode.setContext(callAstNodeExpression.getParams());

        if (!(parent instanceof CallAstNode)) {
            ExpressionStatementAstNode expressionStatementAstNode = new ExpressionStatementAstNode();

            expressionStatementAstNode.setExpression(callAstNodeExpression);

            parent.getContext().add(expressionStatementAstNode);
        }
        else {
            parent.getContext().add(callAstNodeExpression);
        }

        List<AstNode> params = callAstNode.getParams();

        for (AstNode param : params) {
            param.acceptVisitorWithParent(this, callAstNode);
        }

    }

    @Override
    public void visitProgramAstNode(ProgramAstNode programAstNode, AstNode parent) {
        List<AstNode> childNodes = programAstNode.getChildNodes();

        for (AstNode astNode : childNodes) {
            astNode.acceptVisitorWithParent(this, programAstNode);
        }
    }

    @Override
    public void visitValueAstNode(ValueAstNode valueAstNode, AstNode parent) {
        parent.getContext().add(valueAstNode);
    }

    @Override
    public void visitExpressionStatementAstNode(ExpressionStatementAstNode expressionStatementAstNode, AstNode parent) {
        throw new RuntimeException();
    }

    @Override
    public void visitIdentifierAstNode(IdentifierAstNode identifierAstNode, AstNode parent) {
        throw new RuntimeException();
    }

}
