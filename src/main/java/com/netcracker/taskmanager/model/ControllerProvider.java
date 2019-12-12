
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ControllerProvider {
    private static ControllerProvider instance;

    private ControllerProvider() {
    }

    public static synchronized ControllerProvider getInstance() {
        if (instance == null)
            instance = new ControllerProvider();
        return instance;
    }

    public static <T> T provideClass(Class <T> Controller) throws IOException, ClassNotFoundException {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/java/com/netcracker/taskmanager/model/controllers.properties");
        property.load(fis);
        String controllerImplementation = property.getProperty(Controller.getName());
        Class  Wow = Class.forName(controllerImplementation);
        return (T)Wow;
    }
}
