package ca.mcgill.cs.swdesign.m8.filesystem;

public class PrintVisitor implements Visitor {

    @Override
    public void visitConcreteFile(ConcreteFile concreteFile) {
        System.out.println("filename = " + concreteFile.getName());
    }

    @Override
    public void visitDirectory(Directory directory) {
        System.out.println("directory name = " + directory.getName());
        directory.getFiles().forEach((file) -> file.accept(this));
    }

    @Override
    public void visitSymLink(SymLink symLink) {
        System.out.println("shortcut of: " + symLink.getName());
        symLink.getLinks().forEach((file) -> file.accept(this));
    }
}
