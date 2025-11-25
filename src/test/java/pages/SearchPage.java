package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

     WebDriver driver;
//     constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

     By isResultFound = By.xpath("//div[@id='product-list']/*");
     By isNotResultFound = By.xpath("//*[text()='There is no product that matches the search criteria.']");
     By searchInput = By.name("search");
     By searchButton = By.xpath("//button[@class=\"btn btn-light btn-lg\"]");
     By productItems = By.className("product-layout");
     By noResultMessage = By.className("alert.alert-danger");
     By autocompleteDropdown = By.className("autocomplete-suggestions");
     By sortDropdown = By.id("input-sort");
     By showDropdown = By.id("input-limit");

    public void enterSearchText(String keyword) {
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void search(String keyword) {
        enterSearchText(keyword);
        clickSearch();
    }

    public boolean isResultFound() {
        return !driver.findElements(isResultFound).isEmpty();
    }

    public boolean isNoResultMessageDisplayed() {
        return !driver.findElements(isNotResultFound).isEmpty();
    }


    public void searchWithEnter(String keyword) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(keyword);
        input.sendKeys(Keys.ENTER);
    }

    public long searchWithTiming(String keyword) {
        long start = System.currentTimeMillis();
        search(keyword);
        long end = System.currentTimeMillis();
        return end - start;
    }

    public void typeSearch(String keyword) {
        WebElement input = driver.findElement(searchInput);
        input.clear();
        input.sendKeys(keyword);
    }
    

    public String getPlaceholderText() {
        WebElement input = driver.findElement(searchInput);
        return input.getAttribute("placeholder").trim();    }

    public boolean isAutocompleteShown() {
        List<WebElement> suggestions = driver.findElements(autocompleteDropdown);
        return !suggestions.isEmpty();
    }

    public boolean isResultsLayoutCorrect() {
        List<WebElement> products = driver.findElements(productItems);
        for (WebElement product : products) {
            if (!product.isDisplayed()) {
                return false;
            }
        }
        return true;
    }




    public void enableSearchInDescriptions() {
        WebElement checkbox = driver.findElement(By.name("description"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // *************** Sorting & Filters ****************

    public void sortBy(String optionText) {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[contains(text(),'" + optionText + "')]")).click();
    }

    public boolean isSortedByName() {
        List<WebElement> products = driver.findElements(productItems);
        String prev = "";
        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector("h4 a")).getText();
            if (prev.compareToIgnoreCase(name) > 0) return false;
            prev = name;
        }
        return true;
    }

    public boolean isSortedByPriceDesc() {
        List<WebElement> products = driver.findElements(productItems);
        double prev = Double.MAX_VALUE;
        for (WebElement product : products) {
            String priceText = product.findElement(By.cssSelector(".price")).getText().replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceText);
            if (price > prev) return false;
            prev = price;
        }
        return true;
    }

    public boolean isSortedByRating() {
        List<WebElement> products = driver.findElements(productItems);
        int prev = Integer.MAX_VALUE;
        for (WebElement product : products) {
            List<WebElement> stars = product.findElements(By.cssSelector(".rating .fa-star"));
            int rating = stars.size();
            if (rating > prev) return false;
            prev = rating;
        }
        return true;
    }

    public void setShowCount(int count) {
        WebElement dropdown = driver.findElement(showDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + count + "']")).click();
    }

    public int getDisplayedProductCount() {
        return driver.findElements(productItems).size();
    }

}
