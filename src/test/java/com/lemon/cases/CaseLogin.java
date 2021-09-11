package com.lemon.cases;

import com.lemon.commons.CaseBase;
import com.lemon.commons.UIAssert;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import com.lemon.pages.UserInfoPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Project: APP202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-09-01 20:46
 * @Desc：
 **/
public class CaseLogin extends CaseBase {


    @BeforeTest
    public void setup() throws Exception {
        //连接appium
        driver = getDriver();
        //隐式等待
        implicitlyWait(5);
    }

    @AfterTest
    public void teardown() throws Exception {
        Thread.sleep(4000);
        close(driver);
    }

    @Test
    public void successLogin() throws Exception {
        //首页
        IndexPage indexPage = new IndexPage(driver);
        indexPage.myLemonClick();
        //用户信息页
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.avatarClick();
        //登录页
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("13323234545","234545");
        Thread.sleep(2000);
        //断言：用户名是否变成 登录用户名
        String avatarTitle = userInfoPage.getAvatarTitle();
        UIAssert.assertEquals(avatarTitle,"歪歪");
    }
}
