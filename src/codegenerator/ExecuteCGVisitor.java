package codegenerator;

import ast.Program;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.statement.*;
import ast.statement.expression.*;
import ast.type.*;


public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void>{

    private CodeGenerator codeGenerator;
    private AddressCGVisitor address;
    private ValueCGVisitor value;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
        address = new AddressCGVisitor(codeGenerator);
        value = new ValueCGVisitor(codeGenerator);
    }

    @Override
    public Void visit(Program program, Void o) {
        // 1. Comentarios de Variables Globales
        codeGenerator.comment("Global Variables");
        for (Definition def : program.getDefinitions()) {
            if (def instanceof VariableDefinition) {
                def.accept(this, o);
            }
        }
        // 2. Invocación a main
        codeGenerator.comment("");
        codeGenerator.comment("Invocation to the main function");
        codeGenerator.call("main");
        codeGenerator.halt();
        // 3. Definiciones de funciones
        for (Definition def : program.getDefinitions()) {
            if (def instanceof FunctionDefinition) {
                def.accept(this, o);
            }
        }
        return null;
    }

    /**
     * execute[[FunctionDefinition: def -> statements]] =
     *      ID ":"
     *      ' * Parameters: (lista de params)
     *      ' * Local Variables: (lista de variables locales)
     *      enter total_local_variables_size
     *      statements*.execute()
     *      if (def.type.returnType is VoidType)
     *          ret 0, total_local_variables_size, total_parameters_size
     */
    @Override
    public Void visit(FunctionDefinition funcDef, Void o) {
        codeGenerator.line(funcDef.getLine());
        // 1. Etiqueta de la función (ej: "main:")
        codeGenerator.label(funcDef.getName());
        // 2. Comentario informativo
        codeGenerator.comment("Parameters & Local variables info");
        int bytesLocales = 0;
        int bytesParams = 0;
        int bytesReturn = funcDef.getType().numberOfBytes();
        // 3. Reservar espacio para las variables locales
        codeGenerator.enter(bytesLocales);
        // 4. Ejecutar todas las sentencias (Statements) del cuerpo
        for (Statement stmt : funcDef.getStatements()) {
            stmt.accept(this, o);
        }
        // 5. Si la función no devuelve nada (void), ponemos un ret automático al final
        // Si la función devuelve algo, el ret lo generará el ReturnVisitor.
        if (bytesReturn == 0) {
            codeGenerator.ret(0, bytesLocales, bytesParams);
        }
        return null;
    }

    @Override
    public Void visit(VariableDefinition varDef, Void o) {
        codeGenerator.line(varDef.getLine());
        codeGenerator.comment(varDef.getType().toString() + " " + varDef.getName() + " (offset " + varDef.getOffset() + ")");
        return null;
    }

    /**
     * execute[[Assignment: statement → exp1 exp2]] =
     *      address[[exp1]]
     *      value[[exp2]]
     *      exp2.type.convertTo(exp1.type)
     *      store exp1.type.suffix()
     */
    @Override
    public Void visit(Assignment assignment, Void o) {
        assignment.getLeftExpression().accept(address, o);
        assignment.getRightExpression().accept(value, o);
        codeGenerator.convert(assignment.getRightExpression().getType(),
                assignment.getLeftExpression().getType());
        codeGenerator.store(assignment.getLeftExpression().getType().suffix());
        return null;
    }

    /**
     * execute[[Input: statement -> expression*]] =
     *      expression*.forEach(exp => {
     *          address[[exp]]
     *          in exp.type.suffix()
     *          store exp.type.suffix()
     *      })
     */
    @Override
    public Void visit(Input input, Void o) {
        for (Expression exp : input.getExpressions()) {
            exp.accept(address, o);
            char suffix = exp.getType().suffix();
            codeGenerator.in(suffix);
            codeGenerator.store(suffix);
        }
        return null;
    }

    /**
     * execute[[Print: statement -> expression*]] =
     *      expression*.forEach(exp => {
     *          value[[exp]]
     *          out exp.type.suffix()
     *      })
     */
    @Override
    public Void visit(Print print, Void o) {
        for (Expression exp : print.getExpressions()) {
            exp.accept(value, o);
            char suffix = exp.getType().suffix();
            codeGenerator.out(suffix);
        }
        return null;
    }

    // NO HACER
    @Override
    public Void visit(Return ret, Void o) {
        ;
        return null;
    }

    // NO HACER
    @Override
    public Void visit(While whileStatement, Void o) {
        ;
        return null;
    }

    // NO HACER
    @Override
    public Void visit(FunctionInvocation funcInvoc, Void o) {
        ;
        return null;
    }

    // NO HACER
    @Override
    public Void visit(IfElse ifElse, Void o) {
        ;
        return null;
    }

}
