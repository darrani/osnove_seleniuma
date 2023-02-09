package p06_02_2023;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BootsnippTableTest extends BaseTest {

    @Test (priority = 1)
    public void editRowTest(){
        driver.get(baseUrl = "/frame/K5yrx");
        tablePage.getEditButtonByRow(1).click();
        editDialogPage.waitForDialogToBeVisible();
        editDialogPage.getFirstNameInput().clear();
        editDialogPage.getFirstNameInput().sendKeys("Dragana");
        editDialogPage.getLastNameInput().clear();
        editDialogPage.getLastNameInput().sendKeys("Nikolic");
        editDialogPage.getMiddleNameInput().clear();
        editDialogPage.getMiddleNameInput().sendKeys("Radomir");
        editDialogPage.getUpdateButton().click();
        editDialogPage.waitForDialogToBeInvisible();

        Assert.assertEquals(tablePage.getTableBodyColumn(1, 2).getText(),
                "Dragana", "First name is not update");

        Assert.assertEquals(tablePage.getTableBodyColumn(1, 3).getText(),
                "Dragana", "Last name is not update");

        Assert.assertEquals(tablePage.getTableBodyColumn(1, 4).getText(),
                "Dragana", "Middle name is not update");
    }

    @Test (priority = 2)

    public void deleteRowTest(){
        driver.get(baseUrl + "/iframe/K5yrx");
        tablePage.getDeleteButtonByRow(1).click();
        deleteDialogPage.waitForDialogToBeVisible();
        deleteDialogPage.getDeleteButton().click();
        deleteDialogPage.waitForDialogToBeInvisible();
        tablePage.waitForRowToBeDelete(1);
    }


}
