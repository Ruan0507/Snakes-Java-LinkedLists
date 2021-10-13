
/**
 * Write a description of class Apple here.
 * 
 * @author (Ruan Small) 
 * @version (a version number or a date)
 */

public class Apple
{
    private int rowPos;
    private int colPos;
    
    public Apple(int x,int y)
    {
        rowPos=x;
        colPos=y;
    }
    
    public int getRow()
    {
     return rowPos;
    }
    
    public int getCol()
    {
     return colPos;
    }
    
}
