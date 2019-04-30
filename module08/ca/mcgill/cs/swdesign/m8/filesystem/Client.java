package ca.mcgill.cs.swdesign.m8.filesystem;

class Client {
    public static void main(String[] args) {
        Directory movies = new Directory("movies");
        ConcreteFile endgame = new ConcreteFile("Avengers: Endgame (2018)");
        ConcreteFile ragnarok = new ConcreteFile("Thor: Ragnarok (2017)");
        movies.addFile(endgame);
        movies.addFile(ragnarok);
        SymLink symLink = new SymLink();
        symLink.addLink(movies);
        symLink.accept(new PrintVisitor());
    }
}
