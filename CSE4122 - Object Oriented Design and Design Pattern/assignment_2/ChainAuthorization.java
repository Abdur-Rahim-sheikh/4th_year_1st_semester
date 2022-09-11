public class ChainAuthorization {
    private static AbstractWithdraw getChainAuthorize(String name){
        AbstractWithdraw manager = new Manager(AbstractWithdraw.MANAGER_LEVEL,name);
        AbstractWithdraw senior_officier = new SeniorOfficier(AbstractWithdraw.SENIOR_LEVEL,name,manager);
        AbstractWithdraw cashier = new Cashier(AbstractWithdraw.CASHIER_LELVEL,name,senior_officier);

        // cashier.setNextWithdraw(fileWithdraw);
        // senior_officer.setNextWithdraw(consoleWithdraw);

        return cashier;
    }

    public static void main(String[] args){
        String name="Abir";
        AbstractWithdraw WithdrawChain = getChainAuthorize(name);

        WithdrawChain.authorizeWithdrawal(AbstractWithdraw.CASHIER_LELVEL, 
            "Money Withdray");

        WithdrawChain.authorizeWithdrawal(AbstractWithdraw.SENIOR_LEVEL, 
            "High amount of money withdraw");
        // System.out.println("ACCCCCC");

        WithdrawChain.authorizeWithdrawal(AbstractWithdraw.MANAGER_LEVEL,
        "Very high amount of money withdrawl");

    }
    
}
