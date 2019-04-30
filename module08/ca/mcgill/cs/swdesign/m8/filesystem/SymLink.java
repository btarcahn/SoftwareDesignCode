package ca.mcgill.cs.swdesign.m8.filesystem;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class SymLink implements FileInterface {
    private Set<FileInterface> links = new HashSet<>();

    Set<FileInterface> getLinks() {
        return new HashSet<>(this.links);
    }

    void addLink(FileInterface link) {
        this.links.add(link);
    }
    @Override
    public String getName() {
        return links.stream().map(FileInterface::getName).collect(Collectors.toList()).toString();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSymLink(this);
    }
}
