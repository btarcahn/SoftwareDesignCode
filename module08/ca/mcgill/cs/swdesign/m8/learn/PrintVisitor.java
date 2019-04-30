package ca.mcgill.cs.swdesign.m8.learn;

class PrintVisitor implements Visitor {
    @Override
    public void visitParent(Parent parent) {
        System.out.println("--------------------");
        System.out.println("Parent name: " + parent.getName());
        parent.getChildren().forEach((child) -> child.accept(this));
    }

    @Override
    public void visitChild(Child child) {
        System.out.println("Child name: " + child.getName() + ", age = " + child.getAge());
    }
}
