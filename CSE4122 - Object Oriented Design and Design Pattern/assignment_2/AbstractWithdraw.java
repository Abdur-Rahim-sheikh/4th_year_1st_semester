public abstract class AbstractWithdraw{
    public static int CASHIER_LELVEL = 1;
    public static int SENIOR_LEVEL = 2;
    public static int MANAGER_LEVEL = 3;
    public String[] name={"Cashier","Senior officier","Manager"};
    protected int level;
    protected String client;
    protected AbstractWithdraw nextWithdraw;
   

    public void setNextWithdraw(AbstractWithdraw nextWithdraw){
        this.nextWithdraw = nextWithdraw;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void authorizeWithdrawal(int level, String message){
        System.out.print(name[this.level-1]+" Authorizing ");

        if(this.level >= level){
            write(message);
            System.out.println(" and Finalized\nCongratulation Mr. "+this.client+" !");
        }
        else if(nextWithdraw !=null){
            System.out.print("\n... requesting above ");
            nextWithdraw.authorizeWithdrawal(level, message);
        }
    }

    abstract protected void write(String message);

}