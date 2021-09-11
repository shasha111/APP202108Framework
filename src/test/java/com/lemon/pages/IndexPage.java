package com.lemon.pages;

import com.lemon.commons.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @Project: APP202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-30 21:47
 * @Desc：
 **/
public class IndexPage extends BasePage {

    //题库按钮
    private By tikuBy = By.xpath("//android.widget.FrameLayout[@content-desc=\"题库\"]");
    //我的柠檬按钮
    private By myLemonBy = MobileBy.AccessibilityId("我的柠檬");

    public IndexPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * 点击题库按钮
     */
    public void tikuClick() {
        click(tikuBy);
    }

    /**
     * 点击我的柠檬
     */
    public void myLemonClick() {
        click(myLemonBy);
    }


}
