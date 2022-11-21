public abstract class Walk{

    int[] row = {-1,0,1,0};
    int[] col = {0,1,0,-1};
    int X,Y,POS;
    
    public abstract void execute();
    
    public int getX(){ return X;}
    public int getY(){ return Y;}
    public void setX(int x){ X = x;}
    public void setY(int y){ Y = y;}
}