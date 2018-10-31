package ht222fd_assign3.Ex4To7;
/*
Create a class Word, representing a word. Two words should be considered equal if they consist of the same sequence of
letters and we consider upper case and lower case as equal. For example hello, Hello and HELLO are considered to be
equal. The methods equals and hashCode define the meaning of "equality".
* */

public class Word implements Comparable<Word> {
    private String word;
    private String wordLower;

    public String getWordLower() {
        return wordLower;
    }


    /*------------CONSTRUCTOR-----------------*/

    public Word(String str) {
        this.word = str;
        this.wordLower = str.toLowerCase();
    }


    /*--------------METHODS-----------------*/

    public String toString() { return word; }

    /* Override Object methods */
    /*I spent a lot of time doing my own hashfunction and
    * the slack groups says that you don't need it, gg me.*/
    public int hashCode() {
        return this.wordLower.hashCode();
    }

    public boolean equals(Object other) {
        if (this.hashCode() == other.hashCode()){
            return true;
        }
        return false;
    }

    /* Implement Comparable */

    public int compareTo(Word w) {
        /*We have this.word and w. Take the size of both and give me the
        minimum length of they two.
        Do a loop to check that this.word is the same as/included in w.word.
        If they are not the same, order it.
        If they are the same (like "ana" and "anastasia") the longer one goes last.
        * */

        String mine = this.getWordLower();
        String other = w.getWordLower();

        int mySize = this.getWordLower().length();
        int otherSize = w.getWordLower().length();

        int minLength = Math.min(mySize, otherSize);

        for (int i = 0; i < minLength; i++) {
            int myChar = mine.charAt(i);
            int otherChar = other.charAt(i);

            if (myChar < otherChar)
                return -1;
            else if (myChar > otherChar)
                return 1;
        }

        if (mySize < otherSize)
            return -1; //if "ANASTASIA" > "ANA", "ANA" goes first.
        else if (mySize > otherSize)
            return 1;

        return 0; //If nothing above triggers a return, they must be equal.

    }



}