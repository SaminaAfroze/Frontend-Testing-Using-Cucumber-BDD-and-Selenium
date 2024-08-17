package com.soc.steps;

import com.soc.base.AutomationBase;
import com.soc.utils.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends AutomationBase {
    protected TestContext testContext;
    Scenario scenario;

    @Before
    public void setup() {
        loadConfigs();
        instantiateWebDriverObjects();

    }
    @After
    public void tearDown (Scenario scenario) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd-hh");
        Date date = new Date();
        this.scenario = scenario;
        System.out.println("scenario is fails: " +scenario.isFailed());
        System.out.println("scenario status: " +scenario.getStatus());
        if (scenario.isFailed() || scenario.getStatus() != Status.PASSED) {
            final byte[] failshot = AutomationBase.screenShot();

            Files.write(Paths.get("./target/" + scenario.getName().replace(" ", "") + "_fail.png"), failshot);
            scenario.attach(failshot, "image/png", scenario.getName().replace(" ", "") + "_fail.png");
            System.out.println("In teardown, just attached image for " + scenario.getName());
        }
        closeAutomationObjects();

        System.out.println("In teardown, just closed driver for scenario " + scenario.getName());
    }

}