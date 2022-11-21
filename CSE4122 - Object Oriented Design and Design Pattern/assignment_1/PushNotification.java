public class PushNotification implements Notification{

    @Override
    public void notifyUser(String message) {
        System.out.println("PushNotification is handling: "+message);
        
        
    }
    
}
