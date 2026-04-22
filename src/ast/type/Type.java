package ast.type;

import ast.ASTNode;
import ast.Locatable;

import java.util.List;

public interface Type extends ASTNode {
    public void mustBeBuiltIn(Locatable locatable);
    public void mustBeLogical(Locatable locatable);
    public Type arithmetic(Type t, Locatable locatable);
    public Type arithmetic(Locatable locatable);
    public Type logic(Type t, Locatable locatable);
    public Type logic(Locatable locatable);
    public void mustPromoteTo(Type type, Locatable locatable);
    public Type canBeCastTo(Type type, Locatable locatable);
    public Type comparison(Type t, Locatable locatable);
    public Type squareBrackets(Type t, Locatable locatable);
    public Type dot(String c, Locatable locatable);
    public Type parenthesis(List<Type> p, Locatable locatable);
    public int numberOfBytes();
    public char suffix();
    public Type superType(Type type);
}
