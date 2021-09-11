package com.lemon.commons;

import com.lemon.constants.Constant;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @Project: UI202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-25 20:15
 * @Desc：
 **/
public class CaseBase {

    public AndroidDriver driver;

    private static Logger logger = Logger.getLogger(CaseBase.class);


    /**
     *
     * @param driver
     */
    public void close(WebDriver driver) {
        logger.info("【关闭驱动】");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     * 获取不同浏览器的driver对象
     * @param type  浏览器类型
     * @return
     */
    public AndroidDriver getDriver() throws Exception {
        logger.info("【打开appium】");
        //所需功能
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //1、确认测试平台
        capabilities.setCapability("platformName", "Android");
        //2、需要测试的设备
        capabilities.setCapability("deviceName", Constant.DEVICE_NAME);
        //3、测试的app 通过app唯一标识
        capabilities.setCapability("appPackage", Constant.APP_PACKAGE);
        //4、启用app 调用appActivity
        capabilities.setCapability("appActivity", Constant.APP_ACTIVITY);
        //5、记录app用户信息
//        capabilities.setCapability("noReset", true);
        //5、客户端（java脚本）和Appium server 建立连接
        URL url = new URL(Constant.APPIUM_URL);
        //6、创建AndroidDriver 对象
        driver = new AndroidDriver(url, capabilities);
        return driver;
    }




    /**
     * 隐式等待
     * @param seconds 等待时间
     */
    public void implicitlyWait(int seconds) {
        logger.info("【开启隐式等待，等待时长："+seconds+"s】");
        driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
    }


    /**
     * 浏览器截图
     * @return  图片File对象
     */
    public File getScreenshotFile() {
        logger.info("【截图 文件】");
        return driver.getScreenshotAs(OutputType.FILE);
    }

    /**
     * 浏览器截图
     * @return  图片字节流
     */
    public byte[] getScreenshotBytes() {
        logger.info("【截图 字节流】");
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    /**
     * 返回app第一个页面
     */
    public void backIndex() {
        logger.info("【返回app第一个页面】");
        Activity activity = new Activity(Constant.APP_PACKAGE,Constant.APP_ACTIVITY);
        driver.startActivity(activity);
    }

}
