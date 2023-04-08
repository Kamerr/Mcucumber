package com.step_defs;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import com.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
       // Driver.get().manage().window().getPosition(new Point(-1000,0));
       // Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        System.out.println("This is coming from before method");
    }
    @After
    public void tearDown(Scenario scenario){
        System.out.println("This is coming from After method");
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }
}
