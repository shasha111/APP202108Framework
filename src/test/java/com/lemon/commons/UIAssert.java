package com.lemon.commons;

import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * @Project: UI202108Framework
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2021 版权所有 湖南省零檬信息技术有限公司
 * @Author: luojie
 * @Create: 2021-08-27 21:31
 * @Desc：
 **/
public class UIAssert {

    private static Logger logger = Logger.getLogger(UIAssert.class);

    public static void assertEquals(Object actual,Object expected) {
        logger.info("【等值断言，实际值："+actual+"，期望值："+expected+"】");
        try {
            Assert.assertEquals(actual,expected);
        }catch (AssertionError e) {
            logger.error(e);
            throw e;
        }
    }

    public static void assertTrue(boolean flag) {
        logger.info("【等值断言，实际值：true，期望值："+flag+"】");
        try {
            Assert.assertTrue(flag);
        }catch (AssertionError e) {
            logger.error(e);
            throw e;
        }
    }
}
