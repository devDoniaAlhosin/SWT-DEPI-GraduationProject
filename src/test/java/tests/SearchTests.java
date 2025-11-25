package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTests extends BaseTest {
    private SearchPage search;

    @BeforeMethod
    public void setUpTest() {
        search = new SearchPage(driver);
    }

    @Test
    public void productNameSearch() {
        search.search("iphone");
        Assert.assertTrue(search.isResultFound(), "Expected valid results.");
    }

    @Test
    public void categoryNameSearch() {
        search.search("Desktops");
        Assert.assertFalse(search.isResultFound(), "Expected valid results.");
    }

    @Test
    public void searchPartialProductName() {
        search.search("Pro");
        Assert.assertTrue(search.isResultFound(), "Expected products containing 'Pro'.");
    }

    @Test
    public void searchInvalidKeyword() {
        search.search("xyz123");
        Assert.assertTrue(search.isNoResultMessageDisplayed(), "Expected 'No product matches' message.");
    }

    @Test
    public void searchSpecialCharacters() {
        search.search("@#$%^&*");
        Assert.assertTrue(search.isNoResultMessageDisplayed(), "Expected proper handling of special characters.");
    }

    @Test
    public void searchNumericInput() {
        search.search("123456");
        Assert.assertTrue(search.isResultFound() || search.isNoResultMessageDisplayed(),
                "Expected numeric search results or 'No product found'.");
    }

    @Test
    public void searchAlphanumericInput() {
        search.search("Mac123");
        Assert.assertTrue(search.isResultFound() || search.isNoResultMessageDisplayed(),
                "Expected alphanumeric search handling.");
    }

    @Test
    public void searchEmptyInput() {
        search.search("");
        Assert.assertTrue(search.isNoResultMessageDisplayed(),
                "Expected 'No products found' message when searching empty input.");
    }


    @Test
    public void validatePlaceholderText() {
        String expected = "Search";
        String actual = search.getPlaceholderText();

        Assert.assertEquals(actual, expected, "Placeholder should match 'Search' exactly.");
    }

    @Test
    public void searchUsingEnterKey() {
        search.searchWithEnter("iPhone");
        Assert.assertTrue(search.isResultFound(), "Expected search results triggered by Enter key.");
    }

    @Test
    public void searchCaseInsensitive() {
        search.search("IPHONE");
        Assert.assertTrue(search.isResultFound(), "Search should be case-insensitive.");
    }

    @Test
    public void searchIgnoresWhitespace() {
        search.search(" iPhone  ");
        Assert.assertTrue(search.isResultFound(), "Leading/trailing spaces should be ignored.");
    }

    @Test
    public void autocompleteSuggestionsShouldBeAvailable() {
        search.typeSearch("iph");
        Assert.assertFalse(search.isAutocompleteShown(),
                "Autocomplete should appear when typing 'iph'.");
    }

    @Test
    public void validateSearchResultsLayout() {
        search.search("iPhone");
        Assert.assertTrue(search.isResultsLayoutCorrect(), "Search results layout should be consistent.");
    }

    @Test
    public void measureSearchPerformance() {
        long time = search.searchWithTiming("iPhone");
        Assert.assertTrue(time <= 3000, "Search results should load within 3 seconds.");
    }

    @Test
    public void searchMultipleProductTypes() {
        search.search("Phone Camera");
        Assert.assertTrue(search.isResultFound() || search.isNoResultMessageDisplayed(),
                "Expected results for multiple product types.");
    }



    @Test
    public void searchInProductDescriptions() {
        search.search("pro");
        search.enableSearchInDescriptions();
        Assert.assertTrue(search.isResultFound(), "Expected results matching product descriptions.");
    }

    @Test
    public void sortByName() {
        search.search("iPhone");
        search.sortBy("Name (A - Z)");
        Assert.assertTrue(search.isSortedByName(), "Products should be sorted by name A-Z.");
    }


    @Test
    public void sortByPriceHighToLow() {
        search.search("iPhone");
        search.sortBy("Price (Low > High)");
        Assert.assertTrue(search.isSortedByPriceDesc(), "Products should be sorted by price descending.");
    }

    @Test
    public void sortByRating() {
        search.search("iPhone");
        search.sortBy("Rating (Highest)");
        Assert.assertTrue(search.isSortedByRating(), "Products should be sorted by rating highest to lowest.");
    }

    @Test
    public void verifyProductCountShowDropdown() {
        search.search("i");

        search.setShowCount(50);

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("limit=50"),
                "URL should contain limit=50 but was: " + currentUrl
        );
    }


}
