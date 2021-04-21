package ast;

public interface Visitable {
    void acceptVisitorWithParent(Visitor visitor, AstNode parent);
}
