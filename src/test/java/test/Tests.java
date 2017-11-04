package test;

import app.Application;
import org.testng.annotations.Test;


public class Tests {

    private Application app = new Application();

    @Test
    public void uploadTest() {
        app.login();
        app.upload();
        app.assertion();
    }

}
