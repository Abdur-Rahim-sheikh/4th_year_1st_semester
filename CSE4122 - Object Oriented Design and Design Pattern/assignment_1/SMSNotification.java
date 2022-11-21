public class SMSNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("SMSNotification handling: "+message);
        
    }
    
}
