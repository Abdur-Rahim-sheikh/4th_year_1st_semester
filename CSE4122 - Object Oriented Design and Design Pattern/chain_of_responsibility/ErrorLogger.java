package chain_of_responsibility;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        super(level);
        //TODO Auto-generated constructor stub
    }
    public ErrorLogger(int level,AbstractLogger nextLogger) {
        super(level,nextLogger);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("Error logger logging "+msg);
    }
    
}
