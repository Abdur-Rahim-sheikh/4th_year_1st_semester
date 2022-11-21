package chain_of_responsibility;

public abstract class AbstractLogger {
    public static int INFO = 1,DEBUG=3,ERROR=2;
    private int level;
    private AbstractLogger nextLogger = null;

    public AbstractLogger(int level){
        this.level = level;
    }

    public AbstractLogger(int level,AbstractLogger abstractLogger){
        this.level = level;
        this.nextLogger = abstractLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String msg){
        if(this.level<=level){
            write(msg);
        }
        
        if(nextLogger!=null){
            nextLogger.logMessage(level, msg);
        }
    }

    abstract protected void write(String msg);

}
