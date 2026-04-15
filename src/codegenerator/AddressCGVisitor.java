package codegenerator;

import semantic.AbstractVisitor;

public class AddressCGVisitor extends AbstractVisitor<Void, Void> {

    private CodeGenerator codeGenerator;
    private ValueCGVisitor value;

    public AddressCGVisitor(CodeGenerator codeGenerator){
        codeGenerator = codeGenerator;
        value = new ValueCGVisitor(codeGenerator);
    }
}
