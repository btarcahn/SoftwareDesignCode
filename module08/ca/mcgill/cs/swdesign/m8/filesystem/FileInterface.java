package ca.mcgill.cs.swdesign.m8.filesystem;

interface FileInterface {
    String getName();
    void accept(Visitor visitor);
}
