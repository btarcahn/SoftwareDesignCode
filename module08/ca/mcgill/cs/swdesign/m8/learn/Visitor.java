package ca.mcgill.cs.swdesign.m8.learn;

interface Visitor {
    void visitParent(Parent parent);
    void visitChild(Child child);
}
