/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restcontroller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreedingController {

    public static WebDriver webDriver = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeding() {

        return "Hello ";
    }

    @RequestMapping(value = "/cmd", method = RequestMethod.GET)
    public String greeding(@RequestParam(value = "cmd", required = true) String cmd) {
        String output = "";
        try {
            output = executeCommand(cmd);
            return output;
        } catch (Exception e) {
            e.getMessage();
            return e.getMessage();
        }

    }

    @RequestMapping(value = "/openbrowser", method = RequestMethod.GET)
    public String selenium() {
        String output = "";
        try {
//            System.setProperty("webdriver.chrome.driver",
//                    "/app/chromedriver");

            //System.setProperty("webdriver.gecko.drive",
            //       "C:\\Users\\Hello\\Downloads\\Compressed\\geckodriver-v0.16.0-win64\\geckodriver.exe");
            //File pathToBinary = new File("E:\\Soft\\FirefoxPortable\\App\\Firefox64\\firefox.exe");
            //FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            //FirefoxProfile firefoxProfile = new FirefoxProfile();
            webDriver = new HtmlUnitDriver();
            openTestSite();
            login("admin", "12345");
            getText();

            closeBrowser();
            return getText();
        } catch (Exception e) {
            e.getMessage();
            return e.getMessage();
        }

    }

    public void login(String username, String Password) {

        try {
            WebElement userName_editbox = webDriver.findElement(By.id("usr"));
            WebElement password_editbox = webDriver.findElement(By.id("pwd"));
            WebElement submit_button = webDriver.findElement(By.xpath("//input[@value='Login']"));

            userName_editbox.sendKeys(username);
            password_editbox.sendKeys(Password);
            submit_button.click();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public String getText() throws IOException {

        try {
            String text = webDriver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
            return text;
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public void closeBrowser() {
        webDriver.close();
    }

    public void openTestSite() {
        webDriver.navigate().to("http://testing-ground.scraping.pro/login");
    }

    public String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

}
