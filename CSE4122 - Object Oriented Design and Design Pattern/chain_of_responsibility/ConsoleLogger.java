package chain_of_responsibility;

public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        super(level);
        //TODO Auto-generated constructor stub
    }
    public ConsoleLogger(int level,AbstractLogger nextLogger) {
        super(level,nextLogger);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("Console logger logging "+msg);
    }
    
}
