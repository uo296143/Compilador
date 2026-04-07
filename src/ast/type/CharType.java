package ast.type;

import visitor.Visitor;

public class CharType extends AbstractType{

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> visitor, TP parameter) {
        return visitor.visit(this, parameter);
    }

    @Override
    public String typeExpression() {
        return super.typeExpression();
    }

    @Override
    public Type arithmetic(Type t){
        return ;
    }
}
