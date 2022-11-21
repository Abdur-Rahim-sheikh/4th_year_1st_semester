public class WalkForward extends Walk{
    public WalkForward(int pos){
        POS = pos;
    }
    @Override
    public void execute() {
        X = X + row[POS];
        Y = Y + col[POS];
        System.out.println("Forwarded to : "+X+" "+Y);
    }
    
    
}
