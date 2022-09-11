public class Manager extends AbstractWithdraw{

    public Manager(int level,String name){
        this.level = level;
        this.client = name;
        this.nextWithdraw = null;
    }
    public Manager(int level,String name, AbstractWithdraw next){
        this.level = level;
        this.client = name;
        this.nextWithdraw = next;
    }
    @Override
    protected void write(String message) {
        // TODO Auto-generated method stub
        System.out.print("\nTop log: "+message);
    }
    
}
