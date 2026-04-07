package ast.type;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {
    public String typeExpression();
    public Type arithmetic(Type t);
    public Type squareBrackets(Type t);
    public Type parenthesis(List<Type> p);
    public Type dot(String c);
    public boolean equivalent(Type t);
    public Type comparison(Type t);
    public boolean mustBeLogical();
    public boolean mustBeBuiltIn();
    public boolean canBeCastTo();
}
