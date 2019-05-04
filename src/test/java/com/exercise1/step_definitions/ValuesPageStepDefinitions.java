package com.exercise1.step_definitions;

import com.exercise1.utilities.ConfigurationReader;
import com.exercise1.utilities.Driver;
import com.exercise1.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ValuesPageStepDefinitions {

    Pages pages = new Pages();

    @Given("User on Values Page")
    public void user_on_Values_Page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("^Assert count of labels equals count of text values$")
    public void assert_count_of_labels_equals_count_of_text_values() {
        assertThat(pages.values().lbl, hasSize(pages.values().txt.size()));

    }

    @Then("Assert every value on the screen is greater than (\\d+)")
    public void assert_every_value_on_the_screen_is_greater_than(double arg1)  {
        for (WebElement label : pages.values().txt){
            assertThat(Double.valueOf(label.getText().substring(1)),greaterThan(arg1));
        }

    }

    @Then("Assert the total balance is equal the sum of values")
    public void assert_the_total_balance_is_equal_the_sum_of_values()  {
        double sum = 0.00;
        try{
            for (WebElement label : pages.values().txt){
            sum+=Double.valueOf(label.getText().substring(1));

        }
        Assert.assertEquals(sum, Double.valueOf(pages.values().ttl.getText().substring(1)),0.00);}
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

    }

    @Then("Assert the values are formatted as currencies")
    public void assert_the_values_are_formatted_as_currencies() {
        try {
            for (WebElement label : pages.values().txt) {
                Assert.assertTrue(isFormatted(label.getText()));
            }

            Assert.assertTrue(isFormatted(pages.values().ttl.getText()));
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean isFormatted(String str) {
        if (!str.substring(0, 1).equals("$")) {
            return false;
        }
        str = str.substring(1);

        if (str.substring(0, 1).equals("-") && !str.substring(1).equals("0.00")) {
            str = str.substring(1);
        }

        if (!Character.isDigit(str.charAt(str.length() - 1)) || !Character.isDigit(str.charAt(str.length() - 2))
                || !str.substring(str.length() - 3, str.length() - 2).equals(".")) {
            return false;
        }
        str = str.substring(0, str.length() - 3);

        if (str.length() > 1 && str.substring(0, 1).equals("0") || !Character.isDigit(str.charAt(str.length() - 1))
                || !Character.isDigit(str.charAt(0))) {
            return false;
        }

        String[] spl = str.split(",");
        if (spl.length > 1) {
            for (int i = 1; i < spl.length; i++) {
                if (spl[i].length() != 3 || !Character.isDigit(spl[i].charAt(0)) || !Character.isDigit(spl[i].charAt(1))
                        || !Character.isDigit(spl[i].charAt(2))) {
                    return false;
                }
            }
        }

        if (spl[0].length() > 3) {
            return false;
        }

        for (char ch : spl[0].toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
