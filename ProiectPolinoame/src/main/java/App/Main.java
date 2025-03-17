package App;

import Interface.View;
import Interface.Controller;

public class Main {
    public static void main(String[] args) {
        View view             = new View();
        Controller controller = new Controller(view);
    }
}