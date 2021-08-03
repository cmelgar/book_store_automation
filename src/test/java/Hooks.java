import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.YAMLHelper;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hooks {

    public static WebDriver driver;
    YAMLHelper yamlHelper;

    @Before
    public void setup() throws IOException {

        yamlHelper = new YAMLHelper();
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        String url = yamlHelper.getProperty("url");
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
