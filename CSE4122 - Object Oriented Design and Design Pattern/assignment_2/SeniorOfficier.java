public class SeniorOfficier extends AbstractWithdraw{

    
    public SeniorOfficier(int level, String name){
        this.level = level;
        this.client = name;
        this.nextWithdraw = null;
    }
    public SeniorOfficier(int level,String name, AbstractWithdraw next){
        this.level = level;
        this.client = name;
        this.nextWithdraw = next;
    }
    @Override
    protected void write(String message) {
        // TODO Auto-generated method stub
        System.out.print("\nheavy log: "+message);
    }
    
}
