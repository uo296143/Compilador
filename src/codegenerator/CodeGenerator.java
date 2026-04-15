package codegenerator;

import java.io.*;

public class CodeGenerator {

    private PrintWriter out;

    public CodeGenerator(String inputFileName, String outputFileName) {
        try {
            this.out = new PrintWriter(new FileWriter(outputFileName));
        } catch (IOException e) {
            System.err.println("Error creando el archivo de salida: " + e.getMessage());
        }
    }

    /* --- Métodos Auxiliares --- */

    private void write(String instruction) {
        out.println(instruction);
        out.flush();
    }

    /* --- Instrucciones PUSH --- */

    public void pushb(int value) { write("pushb " + value); }
    public void pushi(int value) { write("pushi " + value); }
    public void pushf(double value) { write("pushf " + value); }
    public void pusha(int address) { write("pusha " + address); }
    public void pushbp() { write("pusha bp"); }

    /* --- Load y Store (Parametrizados) --- */

    public void load(char type) { write("load" + type); }
    public void store(char type) { write("store" + type); }

    /* --- Popping y Duplicating --- */

    public void pop(char type) { write("pop" + type); }
    public void dup(char type) { write("dup" + type); }

    /* --- Operaciones Aritméticas --- */

    public void add(char type) { write("add" + type); }
    public void sub(char type) { write("sub" + type); }
    public void mul(char type) { write("mul" + type); }
    public void div(char type) { write("div" + type); }
    public void mod(char type) { write("mod" + type); }

    /* --- Operaciones de Comparación --- */

    public void gt(char type) { write("gt" + type); }
    public void lt(char type) { write("lt" + type); }
    public void ge(char type) { write("ge" + type); }
    public void le(char type) { write("le" + type); }
    public void eq(char type) { write("eq" + type); }
    public void ne(char type) { write("ne" + type); }

    /* --- Operaciones Lógicas --- */

    public void and() { write("and"); }
    public void or() { write("or"); }
    public void not() { write("not"); }

    /* --- Entrada / Salida --- */

    public void out(char type) { write("out" + type); }
    public void in(char type) { write("in" + type); }

    /* --- Conversiones --- */

    public void b2i() { write("b2i"); }
    public void i2f() { write("i2f"); }
    public void f2i() { write("f2i"); }
    public void i2b() { write("i2b"); }

    /* --- Saltos --- */

    public void label(String id) { write(id + ":"); }
    public void jmp(String label) { write("jmp " + label); }
    public void jz(String label) { write("jz " + label); }
    public void jnz(String label) { write("jnz " + label); }

    /* --- Funciones --- */

    public void call(String id) { write("call " + id); }
    public void enter(int size) { write("enter " + size); }
    public void halt() { write("halt"); }

    public void ret(int bytesReturn, int bytesLocals, int bytesArgs) {
        write("ret " + bytesReturn + ", " + bytesLocals + ", " + bytesArgs);
    }

    /* --- Información de Depuración e hilos --- */

    public void source(String fileName) { write("#source \"" + fileName + "\""); }
    public void line(int lineNumber) { write("#line " + lineNumber); }

    public void comment(String msg) { write("' " + msg); }
}