/*
 * Copyright 2012 selendroid committers.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.openqa.selendroid.webviewdrivertests;

import static org.openqa.selendroid.webviewdrivertests.waiter.TestWaiter.waitFor;
import static org.openqa.selendroid.webviewdrivertests.waiter.WaitingConditions.pageTitleToBe;

import java.util.concurrent.TimeUnit;

import org.openqa.selendroid.tests.internal.BaseAndroidTest;
import org.openqa.selendroid.webviewdrivertests.waiter.WaitingConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Element finding test for the web view part of selendroid.
 * 
 * @author ddary
 */
public class WebElementFindingTest extends BaseAndroidTest {
  public static final String ACTIVITY_CLASS = "org.openqa.selendroid.testapp." + "WebViewActivity";

  private void openWebdriverTestPage(String page) {
    driver.switchTo().window(NATIVE_APP);
    driver.get("and-activity://" + ACTIVITY_CLASS);
    waitFor(WaitingConditions.driverUrlToBe(driver, "and-activity://WebViewActivity"));
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to home screen")));
    WebElement spinner = driver.findElement(By.id("spinner_webdriver_test_data"));
    spinner.click();
    // Hack: to work around the bug that an already open page will not be opened again.
    driver.findElement(By.linkText(HtmlTestData.ABOUT_BLANK)).click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    spinner.click();
    driver.findElement(By.linkText(page)).click();

    driver.switchTo().window(WEBVIEW);
  }


  @Test()
  public void testShouldNotBeAbleToLocateASingleElementByIdThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.id("nonExistantButton"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }
  
  @Test()
  public void testShouldNotBeAbleToLocateASingleElementByCssSelctorThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.cssSelector("nonExistantButton"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateASingleElementByXPathThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.xpath("//*[@id='notThere']"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateASingleElementByTagNameThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.tagName("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateASingleElementByClassThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.className("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateASingleElementByNameThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.name("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateASingleElementByTextThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElement(By.linkText("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test()
  public void testShouldNotBeAbleToLocateMultipleElementsByIdThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.id("nonExistantButton"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }
  
  @Test()
  public void testShouldNotBeAbleToLocateMultipleElementsByCssSelectorThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.cssSelector("nonExistantButton"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateMultipleElementsByXPathThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.xpath("//*[@id='notThere']"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateAMultipleElementsByTagNameThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.tagName("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateMultipleElementsByClassThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.className("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateMultipleElementsByNameThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.name("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldNotBeAbleToLocateMultipleElementsByTextThatDoesNotExist() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);

    try {
      driver.findElements(By.linkText("notThere"));
      Assert.fail("Should not have succeeded");
    } catch (NoSuchElementException e) {
      // this is expected
    }
  }

  @Test
  public void testShouldBeAbleToFindElementAndClickOnLinkIdentifiedByText() throws Exception {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement clickMe = driver.findElement(By.linkText("click me"));
    clickMe.click();

    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }


  @Test
  public void testShouldBeAbleToFindElementAndClickOnLinkIdentifiedById() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElement(By.id("linkId")).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }
  
  @Test
  public void testShouldBeAbleToFindElementAndClickOnLinkIdentifiedByCssSelector() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElement(By.cssSelector("a[id='linkId']")).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }

  @Test
  public void testShouldBeAbleToFindElementAndClickOnLinkIdentifiedByXPath() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElement(By.xpath("//a[@id='linkId']")).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }

  @Test
  public void testShouldBeAbleToFindElementAndGetTextOnLinkIdentifiedByTagName() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement element = driver.findElement(By.tagName("a"));
    Assert.assertEquals(element.getText(), "Open new window");
  }

  @Test
  public void testShouldBeAbleToFindElementAndGetTextOnLinkIdentifiedByClass() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement element = driver.findElement(By.className("myTestClass"));
    Assert.assertEquals(element.getText(), "click me");
  }

  @Test
  public void testShouldBeAbleToFindElementAndGetTextOnLinkIdentifiedByName() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    System.out.println(driver.getPageSource());
    WebElement element = driver.findElement(By.name("nameTest"));
    Assert.assertEquals(element.getText(), "click me");
  }

  @Test
  public void testShouldBeAbleToFindElementsAndClickOnLinkIdentifiedByText() throws Exception {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement clickMe = driver.findElements(By.linkText("click me")).get(0);
    clickMe.click();

    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }


  @Test
  public void testShouldBeAbleToFindElementsAndClickOnLinkIdentifiedById() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElements(By.id("linkId")).get(0).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }
  
  @Test
  public void testShouldBeAbleToFindElementsAndClickOnLinkIdentifiedByCssSelector() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElements(By.cssSelector("a[id='linkId']")).get(0).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }

  @Test
  public void testShouldBeAbleToFindElementsAndClickOnLinkIdentifiedByXPath() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    driver.findElements(By.xpath("//a[@id='linkId']")).get(0).click();
    waitFor(pageTitleToBe(driver, "We Arrive Here"), 15, TimeUnit.SECONDS);
    Assert.assertEquals(driver.getTitle(), "We Arrive Here");
  }

  @Test
  public void testShouldBeAbleToFindElementsAndGetTextOnLinkIdentifiedByTagName() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement element = driver.findElements(By.tagName("a")).get(0);
    Assert.assertEquals(element.getText(), "Open new window");
  }

  @Test
  public void testShouldBeAbleToFindElementsAndGetTextOnLinkIdentifiedByClass() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement element = driver.findElements(By.className("myTestClass")).get(0);
    Assert.assertEquals(element.getText(), "click me");
  }

  @Test
  public void testShouldBeAbleToFindElementsAndGetTextOnLinkIdentifiedByName() {
    openWebdriverTestPage(HtmlTestData.XHTML_TEST_PAGE);
    WebElement element = driver.findElements(By.name("nameTest")).get(0);
    Assert.assertEquals(element.getText(), "click me");
  }

  @Test
  public void testShouldfindAnElementBasedOnId() {
    openWebdriverTestPage(HtmlTestData.FORM_PAGE);
    waitFor(pageTitleToBe(driver, "We Leave From Here"), 10, TimeUnit.SECONDS);

    WebElement element = driver.findElement(By.id("checky"));
    Assert.assertEquals(element.isSelected(), false);
  }
}
