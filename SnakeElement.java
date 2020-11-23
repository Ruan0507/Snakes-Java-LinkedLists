
/**
 * Write a description of class SnakeElement here.
 * 
 * @author (Ruan Small 27027228) 
 * @version (Snakes)
 */
public class SnakeElement
{
    private int rowPos;
    private int colPos;

    public SnakeElement(int x,int y)
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

    public void decCol()
    {
        if(colPos>0)
            colPos--;
    }  

    public void decRow()
    {
        if(rowPos>0)
            rowPos--;
    }  

    public void incCol(int col)
    {
        if(colPos<col-1)
            colPos++;
    }  

    public void incRow(int row)
    {
        if(rowPos<row-1)
            rowPos++;
    }  

}
