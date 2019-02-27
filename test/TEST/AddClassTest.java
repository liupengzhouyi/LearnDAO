package TEST;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddClassTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("开始测试");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("结束测试");
        System.out.println("\n");
    }

    @Test
    public void addNumberI() {
        System.out.println("我不知道这是方法有什么用？");
    }

    @Test
    public void addNumberII() {
        System.out.println("我现在知道有什么用了！");

        AddClass addClass = new AddClass();

        System.out.println(addClass.AddNumber(123,345));
    }
}