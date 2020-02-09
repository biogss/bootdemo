package org.wang.bootdemo.model;

import org.springframework.stereotype.Component;

/**
 * 筹码
 */
@Component
public class Chip{

    //16点数量
    private int sixteenNum = 2;

    //8点数量
    private int eightNum = 4;

    //4点数量
    private int fourNum = 8;

    //2点数量
    private int twoNum = 16;

    //1点数量
    private int oneNum = 32;

    /**
     * 重置点数
     */
    public void reset(){
        sixteenNum = 2;
        eightNum = 4;
        fourNum = 8;
        twoNum = 16;
        oneNum = 32;
    }

    /**
     * 16点是否已经发完
     * @return boolean
     */
    public boolean sixteenIsEmpty() {
        return  this.sixteenNum == 0;
    }

    /**
     * 根据点数分发点数
     */
    public boolean distribute(int point) {
        switch (point) {
            case 16:
                if (this.sixteenNum > 0) {
                    this.sixteenNum--;
                    System.out.println("发放16点");
                    return true;
                }
                return false;
            case 8:
                if (this.eightNum > 0) {
                    this.eightNum--;
                    System.out.println("发放8点");
                    return true;
                }
                return false;
            case 4:
                if (this.fourNum > 0) {
                    this.fourNum--;
                    System.out.println("发放4点");
                    return true;
                }
                return false;
            case 2:
                if (this.twoNum > 0) {
                    this.twoNum--;
                    System.out.println("发放2点");
                    return true;
                }
                return false;
            case 1:
                if (this.oneNum > 0) {
                    this.oneNum--;
                    System.out.println("发放1点");
                    return true;
                }
                return false;
            default:
                System.out.println("没有点数可发");
                 return true;
        }
    }

    public void distributeRule(int point){
        int counter = 1;
        //发放点数不成功循环发送
        while (!distribute(point/counter)) {
            //左移一位相当于乘以2，且速度更快
            counter  = counter << 1;
        }
    }

    /**
     * 8点是否已经发完
     * @return boolean
     */
    public boolean eightIsEmpty() {

        return  this.eightNum == 0;
    }

    /**
     * 4点是否已经发完
     * @return boolean
     */
    public boolean fourIsEmpty() {

        return  this.fourNum == 0;
    }

    /**
     * 2点是否已经发完
     * @return boolean
     */
    public boolean twoIsEmpty() {

        return  this.twoNum == 0;
    }

    /**
     * 1点是否已经发完
     * @return boolean
     */
    public boolean oneIsEmpty() {

        return  this.oneNum == 0;
    }

    /**
     * 瞎子获得一张1点
     */
    public void blind () {
        this.oneNum++;
    }

    public boolean isAllEmpty() {
        if (this.sixteenNum == 0 && this.eightNum == 0 && this.fourNum == 0 &&
        this.twoNum == 0 && this.oneNum == 0) {
            return true;
        }
        return false;
    }
}
