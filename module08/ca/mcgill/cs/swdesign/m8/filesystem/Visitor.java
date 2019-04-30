package ca.mcgill.cs.swdesign.m8.filesystem;

interface Visitor {
    void visitConcreteFile(ConcreteFile concreteFile);
    void visitDirectory(Directory directory);
    void visitSymLink(SymLink symLink);
}
