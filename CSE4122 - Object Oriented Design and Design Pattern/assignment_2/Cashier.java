public class Cashier extends AbstractWithdraw{

    
    public Cashier(int level,String name){
        this.level = level;
        this.client = name;
        this.nextWithdraw = null;
    }
    public Cashier(int level,String name, AbstractWithdraw next){
        this.level = level;
        this.client = name;
        this.nextWithdraw = next;
    }
    @Override
    protected void write(String message) {
        System.out.print("\nLog "+message);
        
    }
    
}
