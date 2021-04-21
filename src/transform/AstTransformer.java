package transform;

import ast.AstNode;

public interface AstTransformer {
    AstNode transform(AstNode inputAstNode);
}
