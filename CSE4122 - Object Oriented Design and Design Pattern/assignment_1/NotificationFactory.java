public class NotificationFactory {
    // I would have made it abstract if more of this kind was introduced here
    // but for simplicity I made just one.
    public void sendNotification(String type,String msg){
        Notification obj =  getNotifier(type);
        if(obj == null){
            System.out.println(type+ " type of notifier does not exists.");
            return;
        }
        obj.notifyUser(msg);
    }
    private Notification getNotifier(String type){
        if(type.equalsIgnoreCase("Email")) return new EmailNotification();
        else if(type.equalsIgnoreCase("SMS")) return new SMSNotification();
        else if(type.equalsIgnoreCase("Push")) return new PushNotification();
        
        return null;
    }
}
