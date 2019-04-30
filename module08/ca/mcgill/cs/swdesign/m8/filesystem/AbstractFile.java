package ca.mcgill.cs.swdesign.m8.filesystem;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractFile implements FileInterface {
    private String aName;

    protected AbstractFile(String pName) {
        aName = pName;
    }
    @Override
    public String getName() {
        return aName;
    }
}

class ConcreteFile extends AbstractFile {

    protected ConcreteFile(String pName) {
        super(pName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteFile(this);
    }
}

class Directory extends AbstractFile {
    private Set<FileInterface> files = new HashSet<>();

    void addFile(FileInterface file) {
        this.files.add(file);
    }

    Set<FileInterface> getFiles() {
        return new HashSet<>(this.files);
    }
    protected Directory(String pName) {
        super(pName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDirectory(this);
    }
}