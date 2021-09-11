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
public class UserInfoPage extends BasePage {

    //头像按钮
    private By avatarBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_image");
    //用户名
    private By avatarTitleBy = By.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");

    public UserInfoPage(AndroidDriver driver) {
        super(driver);
    }

    /**
     * 头像按钮
     */
    public void avatarClick() {
        click(avatarBy);
    }

    /**
     * 获取用户名文本
     * @return
     */
    public String getAvatarTitle() {
        return getElementText(avatarTitleBy);
    }


}
