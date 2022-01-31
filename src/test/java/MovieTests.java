import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MovieTests {

    // creating variables for later use
    String pavadinimas;
    String zanras;
    String aktoriai;
    String rezisierius;
    int trukme;
    int id;

    // Before Methods for Movie Creation
    @BeforeMethod(onlyForGroups = "CreateMovie")
    public void StartCreate() {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        CreateMovie.OpenChrome();
        // change these values
        pavadinimas = "Spanzdbobas ir matrica trilogija";
        zanras = "Simulation";
        aktoriai = "Neo ir spandzbobas";
        rezisierius = "Morpheus";
        trukme = 100;
    }

    @BeforeMethod(onlyForGroups = "EditMovie")
    public void StartEdit() {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        EditMovie.OpenChrome();
        // change these values
        pavadinimas = "Spanzdbobas ir matrica trilogija 3";
        zanras = "Simulation";
        aktoriai = "Neo ir spandzbobas";
        rezisierius = "Morpheus Jr.";
        trukme = 110;
        id = 495;
    }

    @BeforeMethod(onlyForGroups = "RemoveMovie")
    public void StartRemoval() {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver97.exe");
        RemoveMovie.OpenChrome();
        // change this value
        id = 965;
    }

    // After methods
    @AfterMethod(onlyForGroups = "EditMovie")
    public void EndEdit() {
        EditMovie.CloseChrome();
    }

    @AfterMethod(onlyForGroups = "CreateMovie")
    public void EndCreate() {
        CreateMovie.CloseChrome();
    }

    @AfterMethod(onlyForGroups = "RemoveMovie")
    public void EndRemove() {
        RemoveMovie.CloseChrome();
    }

    // Tests
    // Tests for Creating Movies
    @Test(priority = 2, groups = "CreateMovie")
    public void CreateMoviePositive() {
        CreateMovie.PopulateFields(pavadinimas, zanras, aktoriai, rezisierius, trukme);
        Assert.assertEquals(CreateMovie.CreateMovie(), true);
    }

    @Test(priority = 1, groups = "CreateMovie")
    public void CreateMovieNegative() {
        CreateMovie.PopulateFields(pavadinimas, zanras, aktoriai, rezisierius, trukme);
        Assert.assertNotEquals(CreateMovie.CreateMovie(), false);
    }

    //Tests for editing movies
    @Test(priority = 3, groups = "EditMovie")
    public void EditMoviePositive() {

        EditMovie.PopulateFields(pavadinimas, zanras, aktoriai, rezisierius, trukme, id);
        Assert.assertEquals(EditMovie.ConfirmEdit(), true);
    }

    @Test(priority = 4, groups = "EditMovie")
    public void EditMovieNegative() {

        EditMovie.PopulateFields(pavadinimas, zanras, aktoriai, rezisierius, trukme, id);
        Assert.assertNotEquals(EditMovie.ConfirmEdit(), false);
    }

    // Tests For removing movies
    @Test(priority = 5, groups = "RemoveMovie")
    public void RemoveMoviePositive() {

        RemoveMovie.PopulateFields(id);
        Assert.assertEquals(RemoveMovie.DeleteConfirm(), true);
    }
}
