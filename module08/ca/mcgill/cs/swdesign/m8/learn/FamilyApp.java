package ca.mcgill.cs.swdesign.m8.learn;

class FamilyApp {
    public static void main(String[] args) {
        // init family members
        Parent mother = new Parent("mom", 35, 1000);
        Child brother = new Child("baby brother", 2, "apple");
        Child sister = new Child ("older sister", 10, "chocolate");
        mother.addChild(brother);
        mother.addChild(sister);

        Visitor visitor = new PrintVisitor();
        mother.accept(visitor);
    }
}
