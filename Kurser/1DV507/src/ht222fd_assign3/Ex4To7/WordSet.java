package ht222fd_assign3.Ex4To7;

public interface WordSet extends Iterable <Word>{
    public void add(Word word); // Add word if not already added
    public boolean contains(Word word); // Return true if word contained
    public int size(); // Return current set size
    public String toString(); // Print contained words
}
