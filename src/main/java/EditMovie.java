import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditMovie {

    public static final String Link = "http://kitm.epizy.com/filmai.php";
    public static final String PavadinimasName = "pavadinimas";
    public static final String ZanrasName = "zanras";
    public static final String AktoriaiName = "aktoriai";
    public static final String RezisieriusName = "rezisierius";
    public static final String TrukmeName = "trukme";
    public static final String IdName = "id";
    public static final String PatvirtinimasClassName = "msg-good";
    public static final String EditBtnName = "update";

    static ChromeDriver browser;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        String pavadinimas = "Spanzdbobas ir matrica trilogija 2";
        String zanras = "Simulation";
        String aktoriai = "Neo ir spandzbobas";
        String rezisierius = "Morpheus";
        int trukme = 100;
        int id = 922;

        // Opening chrome and navigating to the website
        OpenChrome();
        // Populating fields
        PopulateFields(pavadinimas, zanras, aktoriai, rezisierius, trukme, id);
        ConfirmEdit();

    }
    // Clicking confirm and sending the results back as true - Completed false - failed
    public static boolean ConfirmEdit() {

        browser.findElement(By.name(EditBtnName)).click();

        boolean success;
        try {
            browser.findElement(By.className(PatvirtinimasClassName));
            success = true;
        } catch (NoSuchElementException e) {
            success = false;
        }
        System.out.println("Was the Edit successfull: " + success);
        return success;
    }

    // Finding elements and sending keys to fill in the fields
    public static void PopulateFields(String pavadinimas, String zanras, String aktoriai, String rezisierius, int trukme, int id) {

        WebElement idElement = browser.findElement(By.name(IdName));
        idElement.sendKeys(Integer.toString(id));

        WebElement name = browser.findElement(By.name(PavadinimasName));
        name.sendKeys(pavadinimas);

        WebElement Genre = browser.findElement(By.name(ZanrasName));
        Genre.sendKeys(zanras);

        WebElement actors = browser.findElement(By.name(AktoriaiName));
        actors.sendKeys(aktoriai);

        WebElement director = browser.findElement(By.name(RezisieriusName));
        director.sendKeys(rezisierius);

        WebElement duration = browser.findElement(By.name(TrukmeName));
        duration.sendKeys(Integer.toString(trukme));

    }
    //Opening Chrome
    public static void OpenChrome() {

        browser = new ChromeDriver();
        browser.get(Link);

    }
    //Closing Chrome
    public static void CloseChrome() {
        browser.close();
    }
}
