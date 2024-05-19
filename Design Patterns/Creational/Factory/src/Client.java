public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.createUiFactory("Android");
        Button button = uiFactory.createButton();
        button.changeSize(10);
        button.setText();
    }
}
