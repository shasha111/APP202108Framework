package com.lemon.pages;

import com.lemon.commons.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @Project: APP202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-30 21:47
 * @Desc：
 **/
public class LoginPage extends BasePage {

    //手机号码
    private By phoneBy = By.id("com.lemon.lemonban:id/et_mobile");
    //密码
    private By pwdBy = By.id("com.lemon.lemonban:id/et_password");
    //登录按钮
    private By loginBtnBy = By.id("com.lemon.lemonban:id/btn_login");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * 登录操作
     * @param phone     手机号码
     * @param pwd       密码
     */
    public void login(String phone,String pwd) {
        input(phoneBy,phone);
        input(pwdBy,pwd);
        click(loginBtnBy);
    }


}
