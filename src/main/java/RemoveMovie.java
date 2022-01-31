import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveMovie {

    public static final String Link = "http://kitm.epizy.com/filmai.php";
    public static final String IdName = "id";
    public static final String PatvirtinimasClassName = "msg-good";
    public static final String DeleteBtnName = "delete";
    static ChromeDriver browser;


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        int id = 964;
        // opening chrome
        OpenChrome();
        // populating fields
        PopulateFields(id);
        // clicking delete
        System.out.println(DeleteConfirm());
        // closing chrome
        CloseChrome();

    }

    // Clicking confirm and sending the results back as true - Completed false - failed
    public static boolean DeleteConfirm() {

        browser.findElement(By.name(DeleteBtnName)).click();

        boolean success;
        try {
            browser.findElement(By.className(PatvirtinimasClassName));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("Was the Deletion successfull: " + success);
        return success;

    }
    // Finding elements and sending keys to fill in the fields
    public static void PopulateFields(int id) {

        WebElement idElement = browser.findElement(By.name(IdName));
        idElement.sendKeys(Integer.toString(id));
    }
    // Opening Chrome
    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }
    // Closing Chrome
    public static void CloseChrome() {
        browser.close();
    }
}
