package com.cloud.bssp.designpatterns.adapter;

/**
 * 方钉适配圆洞适配器
 * @date: 2021/1/7
 * @author weirx
 * @version 3.0
 */
public class SquareNailsRoundHoldAdapter {

    public RoundNails getResult(SquareNails squareNails){
        double width = squareNails.getWidth();
        double diagonal = width * Math.sqrt(2);
        RoundNails roundNails = new RoundNails(diagonal);
        return roundNails;
    }
}
