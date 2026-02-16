package ast;

import ast.definition.Definition;

import java.util.List;

public class Program implements ASTNode{

    private List<Definition> definitions;

    public Program(List<Definition> definitions){
        this.definitions = definitions;
    }
}
