
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HomeWork5 {


        private static WebDriverWait wait;
        private static AndroidDriver <WebElement> driver;

        @Before
        public void setup () throws MalformedURLException {

            DesiredCapabilities dc = new DesiredCapabilities ();
            dc.setCapability (MobileCapabilityType.AUTOMATION_NAME,"Appium");
            dc.setCapability (MobileCapabilityType.DEVICE_NAME,"Android Emulator");
            dc.setCapability (MobileCapabilityType.PLATFORM_NAME,"Android");
            dc.setCapability (MobileCapabilityType.PLATFORM_VERSION,"9.0");
            dc.setCapability (MobileCapabilityType.BROWSER_NAME,"chrome");
            dc.setCapability ("appium:chromeOptions",ImmutableMap.of ("w3c",false));

            URL serverURL = new URL ("http://172.22.68.28:4723/wd/hub");


            driver = new AndroidDriver <> (serverURL,dc);
            wait = new WebDriverWait (driver,4);



        }


        @After
        public void stop () {
            driver.closeApp ();
        }


        @Test
        public void CheckTerms () {

            WebDriverWait wait = new WebDriverWait (driver,60);
            driver.navigate ().to ("https://accounts.ukr.net/registration");
            driver.findElement (By.linkText ("Угоди про конфіденційність")).click ();
            String originalW = driver.getWindowHandle ();
            wait.until (ExpectedConditions.numberOfWindowsToBe (2));
            ArrayList <String> existWs = new ArrayList <String> (driver.getWindowHandles ());

            driver.switchTo ().window (existWs.get (1));
            wait.until (ExpectedConditions.titleContains ("Угода про конфіденційність"));
            String TermsUrl = driver.getWindowHandle ();
            String Url = driver.switchTo ().window (TermsUrl).getCurrentUrl ();
            WebElement Name = driver.findElement (By.cssSelector ("h2"));
            String Logo = driver.findElement (By.cssSelector ("img")).getAttribute ("currentSrc");

            Assert.assertEquals ("https://www.ukr.net/terms/",Url);
            Assert.assertEquals ("Угода про конфіденційність",Name.getAttribute ("textContent"));
            Assert.assertEquals ("https://www.ukr.net/img/terms-logo-ua.gif",Logo);
            driver.close ();
            driver.switchTo ().window (originalW);


            driver.findElement (By.cssSelector (".header__lang > button:nth-of-type(2)")).click ();
            driver.findElement (By.linkText ("Соглашением о конфиденциальности")).click ();
            String originalWRu = driver.getWindowHandle ();
            wait.until (ExpectedConditions.numberOfWindowsToBe (2));
            ArrayList <String> existWsRu = new ArrayList <String> (driver.getWindowHandles ());

            driver.switchTo ().window (existWsRu.get (1));
            wait.until (ExpectedConditions.titleContains ("Соглашение о конфиденциальности"));
            String TermsUrlRu = driver.getWindowHandle ();
            String UrlRu = driver.switchTo ().window (TermsUrlRu).getCurrentUrl ();
            WebElement NameRu = driver.findElement (By.cssSelector ("h2"));

            Assert.assertEquals ("https://www.ukr.net/ru/terms/",UrlRu);
            Assert.assertEquals ("Соглашение о конфиденциальности",NameRu.getAttribute ("textContent"));
            driver.close ();
            driver.switchTo ().window (originalWRu);


            driver.findElement (By.cssSelector (".header__lang > button:nth-of-type(1)")).click ();
            driver.findElement (By.linkText ("Угоди про використання електронної пошти FREEMAIL (mail.ukr.net)")).click ();


            String originalWUa = driver.getWindowHandle ();
            wait.until (ExpectedConditions.numberOfWindowsToBe (2));
            ArrayList <String> existWsUa = new ArrayList <String> (driver.getWindowHandles ());

            driver.switchTo ().window (existWsUa.get (1));
            wait.until (ExpectedConditions.titleContains ("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"));
            String TermsUrlUa = driver.getWindowHandle ();
            String UrlUa = driver.switchTo ().window (TermsUrlUa).getCurrentUrl ();
            WebElement NameUa = driver.findElement (By.cssSelector ("h3"));


            Assert.assertEquals ("https://mail.ukr.net/terms_uk.html",UrlUa);
            Assert.assertEquals ("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)",NameUa.getAttribute ("textContent"));
            driver.close ();
            driver.switchTo ().window (originalWUa);


            driver.findElement (By.cssSelector (".header__lang > button:nth-of-type(2)")).click ();
            driver.findElement (By.linkText ("Соглашения об использовании электронной почты FREEMAIL (mail.ukr.net)")).click ();

            String originalWRu2 = driver.getWindowHandle ();
            wait.until (ExpectedConditions.numberOfWindowsToBe (2));
            ArrayList <String> existWsRu2 = new ArrayList <String> (driver.getWindowHandles ());

            driver.switchTo ().window (existWsRu2.get (1));
            wait.until (ExpectedConditions.titleContains ("Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)"));
            String TermsUrlRu2 = driver.getWindowHandle ();
            String UrlRu2 = driver.switchTo ().window (TermsUrlRu2).getCurrentUrl ();
            WebElement NameRu2 = driver.findElement (By.cssSelector ("h3"));

            Assert.assertEquals ("https://mail.ukr.net/terms_ru.html",UrlRu2);
            Assert.assertEquals ("Соглашение об использовании электронной почты FREEMAIL (mail.ukr.net)",NameRu2.getAttribute ("textContent"));
            driver.close ();
            driver.switchTo ().window (originalWUa);


            driver.findElement (By.xpath ("//button[3]")).click ();
            driver.findElement (By.linkText ("the FREEMAIL (mail.ukr.net) Terms of Service")).click ();
            String TermsUrlEng = driver.getWindowHandle ();

            wait.until (ExpectedConditions.numberOfWindowsToBe (2));
            ArrayList <String> existWsEng = new ArrayList <String> (driver.getWindowHandles ());

            driver.switchTo ().window (existWsEng.get (1));
            wait.until (ExpectedConditions.titleContains ("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)"));
            String TermsUrlEng2 = driver.getWindowHandle ();
            String UrlEng = driver.switchTo ().window (TermsUrlEng2).getCurrentUrl ();
            WebElement NameEng = driver.findElement (By.cssSelector ("h3"));


            Assert.assertEquals ("https://mail.ukr.net/terms_en.html",UrlEng);
            Assert.assertEquals ("Угода про використання електронної пошти FREEMAIL (mail.ukr.net)",NameEng.getAttribute ("textContent"));
            driver.close ();

        }


    }




