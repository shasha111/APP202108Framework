package com.lemon.listener;

import com.lemon.commons.CaseBase;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Project: UI202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-30 20:30
 * @Desc：
 **/
public class AllureScreenShotListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //执行@Test测试方法。
        callBack.runTestMethod(testResult);
        //获取@Test测试方法异常
        Throwable throwable = testResult.getThrowable();
        if(throwable != null) {
            //throwable对象不为空，说明@Test方法抛出异常，截图
            //返回当前@Test方法的对象(CaseLogin的对象)
            CaseBase cb = (CaseBase)testResult.getInstance();
            //截图 , 并保存到allure附件中，会在allure报表中显示。
            saveScreenshot(cb.getScreenshotBytes());
        }
    }

    @Attachment(value = "Java screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
