package com.lemon.pages;

import com.lemon.commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Project: APP202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-09-01 20:16
 * @Desc：
 **/
public class TikuPage extends BasePage {
    //题目类型标题
    private By titleBy;
    //题目难度等级
    private By levelBy;
    //试卷标题
    private By subjectTitleBy;
    //显示答案按钮
    private By switchButtonBy = By.id("com.lemon.lemonban:id/switch_button");
    //答案
    private By tvBodyBy = By.id("com.lemon.lemonban:id/tvBody");

    public TikuPage(AndroidDriver driver) {
        super(driver);
    }


    /**
     * 点击题目类型标题
     * @param type  题目类型
     */
    public void clickTitle(String type) {
        titleBy = By.xpath("//*[@text='"+type+"']");
        click(titleBy);
    }

    /**
     * 点击题目难度
     * @param level 题目难度 ：初级，中级，高级
     */
    public void clickLevel(String level) {
        String locator = "";
        if("初级".equals(level)) {
            locator = "com.lemon.lemonban:id/first_level";
        }else if("中级".equals(level)) {
            locator = "com.lemon.lemonban:id/second_level";
        }else if("高级".equals(level)) {
            locator = "com.lemon.lemonban:id/third_level";
        }else {
            locator = "com.lemon.lemonban:id/first_level";
        }
        levelBy = By.id(locator);
        click(levelBy);
    }

    /**
     * 点击试卷标题
     * @param type      与clickTitle()中type参数一致
     * @param level     与clickLevel()中level参数一致
     * @param number    第几套试卷
     */
    public void clickSubjectTitle(String type,String level,String number) {
        //xpath格式:软件测试基础--初级--第3套
        titleBy = By.xpath("//*[@text='"+type+"--"+level+"--第"+number+"套']");
        click(titleBy);
    }

    /**
     * 点击显示答案按钮
     */
    public void clickSwitchButton() {
        click(switchButtonBy);
    }

    /**
     * 答案是否显示
     * @return
     */
    public boolean presenceOfTvBody() {
        return presenceOfElement(tvBodyBy);
    }
}
