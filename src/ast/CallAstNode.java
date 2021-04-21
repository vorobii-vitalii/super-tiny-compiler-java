package ast;

import java.util.ArrayList;
import java.util.List;

public class CallAstNode extends AstNode {
    private String name;
    private final List<AstNode> params = new ArrayList<>();
    private AstNode callee;

    public CallAstNode() {}

    public List<AstNode> getParams() {
        return params;
    }

    public void addParam(AstNode object) {
        params.add(object);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ast.CallAstNode{" +
                "name='" + name + '\'' +
                ", params=" + params +
                ", callee=" + callee +
                '}';
    }

    @Override
    public void acceptVisitorWithParent(Visitor visitor, AstNode parent) {
        visitor.visitCallAstNode(this, parent);
    }

    public AstNode getCallee() {
        return callee;
    }

    public void setCallee(AstNode callee) {
        this.callee = callee;
    }
}
