public class WalkBackward extends Walk{
    public WalkBackward(int pos){
        POS = pos;
    }
    @Override
    public void execute() {
        X = X + row[POS];
        Y = Y + col[POS];
        System.out.println("Backwarded to : "+X+" "+Y);
    }
}
