package com.itheima.utils.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by 13718 on 2017/8/29.
 */
@RunWith(Arquillian.class)
public class TestMailUtilsTest {
    @Test
    public void testMailUtils() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(TestMailUtils.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
