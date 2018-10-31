package ht22fd_assign4;

/*README
 * Yes, it is what it looks.
 * I was using lot of texts to check the assignment
 * so I did a class to write the path to the folder for me.
 * I don't know if I should be proud or embarrassed.
 * */

public class PathFile {
    private String fixedPath = "C:\\Users\\hteva\\IdeaProjects\\1DV506\\src\\ht22fd_assign4\\";

    public String getFullPath(String input){
        String fixed = fixedPath+input;
        return fixed;
    }
}