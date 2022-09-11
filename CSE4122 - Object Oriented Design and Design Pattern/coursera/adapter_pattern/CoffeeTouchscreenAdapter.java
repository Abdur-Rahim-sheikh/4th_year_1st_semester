public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface{
    OldCoffeeMachine coffee;
    public CoffeeTouchscreenAdapter(OldCoffeeMachine coffee){
        this.coffee = coffee;
    }
    @Override
    public void chooseFirstSelection() {
        // TODO Auto-generated method stub
        coffee.selectA();
    }

    @Override
    public void chooseSecondSelection() {
        // TODO Auto-generated method stub
        coffee.selectB();
    }
    
}
