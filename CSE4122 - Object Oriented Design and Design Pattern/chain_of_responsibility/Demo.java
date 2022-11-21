package chain_of_responsibility;

public class Demo {
    private static AbstractLogger chainTheLogger(){
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR,fileLogger);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO,errorLogger);
        return consoleLogger;
    }
    public static void main(String[] args) {
        AbstractLogger logger = chainTheLogger();
        logger.logMessage(3,"abir");
        logger.logMessage(1,"kawsar");
        logger.logMessage(2,"hasibul");
    }
}
