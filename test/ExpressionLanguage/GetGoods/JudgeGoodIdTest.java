package ExpressionLanguage.GetGoods;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeGoodIdTest {

    private JudgeGoodId judgeGoodId = null;

    @Before
    public void setUp() throws Exception {

        judgeGoodId = new JudgeGoodId("2");

    }


    @Test
    public void paly() {
        System.out.println(judgeGoodId.isKey());
    }

    @Test
    public void sayGoods() {
        System.out.println(judgeGoodId.getGood().getGood_id());
        System.out.println(judgeGoodId.getGood().getGood_name());
        System.out.println(judgeGoodId.getGood().getGood_price());
        System.out.println(judgeGoodId.getGood().getGood_number());
    }
}