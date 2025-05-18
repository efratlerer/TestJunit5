import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.*;

public class LogExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("[LogExtension] Starting test log");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("[LogExtension] Cleaning up log after tests");
    }
}
