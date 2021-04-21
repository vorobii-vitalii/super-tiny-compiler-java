package ast;

import java.util.List;

/**
 * Class, that represents node in Abstract Syntax Tree
 */
public abstract class AstNode implements Visitable {
    private List<AstNode> context;

    public List<AstNode> getContext() {
        return context;
    }

    public void setContext(List<AstNode> context) {
        this.context = context;
    }
}
