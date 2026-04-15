package codegenerator;

public class ValueCGVisitor {

    private CodeGenerator codeGenerator;
    private AddressCGVisitor address;

    public ValueCGVisitor(CodeGenerator codeGenerator){
        this.codeGenerator = codeGenerator;
        address = new AddressCGVisitor(codeGenerator);
    }
}
