package com.lemon.commons;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Project: UI202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-27 21:03
 * @Desc：
 **/
public class BasePage {

    private static Logger logger = Logger.getLogger(BasePage.class);
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     * 定位元素输入内容
     * @param by
     * @param text
     */
    public void input(By by, String text) {
        logger.info("【定位("+by+")元素，输入："+text+"】");
        try {
            driver.findElement(by).sendKeys(text);
            //System.out.println(0/0);
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }

    /**
     * 点击元素
     * @param by
     */
    public void click(By by) {
        logger.info("【点击("+by+")元素】");
        try {
            driver.findElement(by).click();
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }

    /**
     * 元素是否显示
     * @param by
     */
    public boolean elementIsDisplay(By by) {
        logger.info("【("+by+")元素是否显示】");
        try {
            return driver.findElement(by).isDisplayed();
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }

    /**
     * 获取元素文本
     * @param by
     */
    public String getElementText(By by) {
        logger.info("【获取("+by+")元素文本】");
        try {
            return driver.findElement(by).getText();
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }


    /**
     * 获取元素文本
     * @param by
     */
    public String getElementAttribute(By by,String name) {
        logger.info("【获取("+by+")元素"+name+"属性】");
        try {
            return driver.findElement(by).getAttribute(name);
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }

    /**
     * 判断元素是否在页面中存在
     * @param by   定位信息
     * @return
     */
    public boolean presenceOfElement(By by) {
        logger.info("【("+by+")元素是否显示】");
        try {
            WebDriverWait wait = new WebDriverWait(driver,3);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return element != null;
        }catch (Exception e) {
            logger.error(e);
            //抛出同样的异常，为什么？阻止程序继续运行。
            throw e;
        }
    }





}
