package com.cloud.bssp.designpatterns.adapter;

import com.cloud.bssp.BsspUserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 测试
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsspUserApplication.class)
public class TestDemo {

    @Test
    public void test() {
        //定义个圆孔
        RoundHold roundHold = new RoundHold(10);
        //定义圆钉
        RoundNails roundNails = new RoundNails(10);
        //定义方钉,边距10
        SquareNails squareNails10 = new SquareNails(10);
        //定义方钉,边距6
        SquareNails squareNails6 = new SquareNails(6);
        //适配器
        SquareNailsRoundHoldAdapter squareNailsRoundHoldAdapter = new SquareNailsRoundHoldAdapter();
        RoundNails result10 = squareNailsRoundHoldAdapter.getResult(squareNails10);
        RoundNails result6 = squareNailsRoundHoldAdapter.getResult(squareNails6);
        //圆钉是否合适
        if (roundHold.fits(roundNails)) {
            System.out.println("this round nails is fits");
        } else {
            System.out.println("this round nails is does not fits");
        }
        //10方钉是否合适
        if (roundHold.fits(result10)) {
            System.out.println("squareNails10 is fits");
        } else {
            System.out.println("squareNails10 is does not fits");
        }
        //6方钉是否合适
        if (roundHold.fits(result6)) {
            System.out.println("squareNails6 is fits");
        } else {
            System.out.println("squareNails6 is does not fits");
        }
    }
}
