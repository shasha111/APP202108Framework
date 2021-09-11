package com.lemon.cases;

import com.lemon.commons.CaseBase;
import com.lemon.commons.UIAssert;
import com.lemon.pages.IndexPage;
import com.lemon.pages.LoginPage;
import com.lemon.pages.TikuPage;
import com.lemon.pages.UserInfoPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @Project: APP202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-09-01 20:59
 * @Desc：
 **/
public class CaseTiku extends CaseBase {


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

    @BeforeClass
    public void beforeClass() throws Exception {
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


    @Test
    public void successTiku() {
        //返回到app首页
        backIndex();
        //首页
        IndexPage indexPage = new IndexPage(driver);
        indexPage.tikuClick();
        //题库页面
        TikuPage tikuPage = new TikuPage(driver);
        tikuPage.clickTitle("软件测试基础");
        tikuPage.clickLevel("初级");
        tikuPage.clickSubjectTitle("软件测试基础","初级","1");
        //显示答案
        tikuPage.clickSwitchButton();
        boolean flag = tikuPage.presenceOfTvBody();
        //断言答案是否显示
        UIAssert.assertTrue(flag);
    }
}
