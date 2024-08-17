package com.soc.base;

import com.soc.constants.CONSTANTS;
import com.soc.constants.GLOBAL;
import com.soc.utils.ConfigReader;
import com.soc.utils.RestUtil;
import com.soc.utils.context.TestContext;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.soc.utils.ConfigReader.getProperty;

public class AutomationBase {

    private static List<AutomationFactory> automationThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<AutomationFactory> driverThread;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    private static String strApiGateway = System.getProperty("apiGateway", "stg");
    protected TestContext testContext;

    public static void instantiateWebDriverObjects() {

            driverThread = ThreadLocal.withInitial(() -> {
            AutomationFactory automationThread = new AutomationFactory();
            automationThreadPool.add(automationThread);
            return automationThread;
        });
    }

    public static void loadConfigs() {
        ConfigReader.readProperties("src/test/resources/configs/credentials.properties");
    }

    public static WebDriver openDriver() {
        return driverThread.get().getDriver();
    }

    public static RequestSpecification getSpec(String apiGateway, boolean isNegative) {
        ConfigReader.readProperties(CONSTANTS.CONFIG_FILE);
        strApiGateway = getProperty(apiGateway);
        System.out.println("This automated api test script is being executed on " + GLOBAL.APPLICATION_ENVIRONMENT + " environment with URL: " + strApiGateway);
        requestSpec = RestUtil.getRequestSpecification(strApiGateway);
        responseSpec = RestUtil.getResponseSpecification(isNegative);

        return requestSpec;
    }
    public static String getApiGateway() {

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                return "productionMainStg";

            case "PRODUCTION":
            case "PROD":
                return "productionMainProd";
            case "DEV":
                return "productionMainDev";
            default:
                return "productionMainStg";
        }
    }
    public static String getApiGatewayforAuthServices(){

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()){
            case "STAGING":
            case "STAG":
            case "STG":
                return "productionMainStgAuthServ";

            case "PRODUCTION":
            case "PROD":
                return "productionMainProd";
            case "DEV":
                return "productionMainDevAuthServ";
            default:
                return "productionMainStgAuthServ";
        }
    }

    public static RequestSpecification getRequestSpecForEndpoint(String apiGateway, String endpoint) {
        ConfigReader.readProperties(CONSTANTS.CONFIG_FILE);
        strApiGateway = getProperty(apiGateway);
        System.out.println("This automated api test script is being executed on test environment with URL: " + strApiGateway + " and endpoint " + endpoint);
        return RestUtil.getRequestSpecification(strApiGateway + endpoint);
    }


    public static void closeAutomationObjects() {


        driverThread.get().quitDriver();

    }

    public static byte[] screenShot() {
        TakesScreenshot ts = (TakesScreenshot) openDriver();

        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static void setWebDriver(WebDriver webDriver) {
    }
}
