package com.exercise1.pages;

import com.exercise1.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Values {
    public Values() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(@id,'lbl_val')]")
    public List<WebElement> lbl;

    @FindBy(xpath = "//*[contains(@id,'txt_val')]")
    public List<WebElement> txt;

    @FindBy(id = "txt_ttl_val")
    public WebElement ttl;


}


