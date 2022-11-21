public class NotificationService{
    public static void main(String[] args){
        NotificationFactory notifier = new NotificationFactory();
        String msg = "I am in danger!";
        notifier.sendNotification("sms", msg);

        notifier.sendNotification("push", msg);

        notifier.sendNotification("email", msg);
    }
}