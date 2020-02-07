package org.wang.bootdemo.model;

import org.springframework.stereotype.Component;

/**
 * 存储最大的状元值
 */

@Component
public class MaxScholar {
    /**
     * 同点个数
     */
    private int num;

    /**
     * 同点点数
     */
    private int point;

    /**
     * 剩余点数（多个用逗号分隔）
     */
    private int module;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public void setMax(int num, int point, int module){
        this.num = num;
        this.point = point;
        this.module = module;
    }
}
