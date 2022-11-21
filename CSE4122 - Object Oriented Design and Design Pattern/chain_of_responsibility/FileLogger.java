package chain_of_responsibility;

public class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        super(level);
        //TODO Auto-generated constructor stub
    }
    public FileLogger(int level,AbstractLogger nextLogger) {
        super(level,nextLogger);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void write(String msg) {
        // TODO Auto-generated method stub
        System.out.println("File logger logging "+msg);
    }
    
}
