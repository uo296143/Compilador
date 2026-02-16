package ast.statement;

import java.util.List;

public class IfElse implements Statement{

    private List<Statement> statements;

    public IfElse(List<Statement> statements){
        this.statements = statements;
    }

}
