package normalObserverPattern;

public class Client {

    public static void main(String[] args) {
    	Observable observable = new ConcreteObservable();

        observable.attach(new ConcreteObserver("X", observable));
        observable.attach(new ConcreteObserver("Y", observable));
        observable.attach(new ConcreteObserver("Z", observable));
        observable.attach(new ConcreteObserver("O", observable));
        observable.attach(new ConcreteObserver("P", observable));
        observable.State = "ABC";
        observable.notifys();

    }

}
