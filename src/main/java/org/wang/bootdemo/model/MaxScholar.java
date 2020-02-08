package org.wang.bootdemo.model;

import org.springframework.stereotype.Component;

/**
 * 存储最大的状元值
 * maxScholar的规则，num代表点数个数，point代表点数,
 * module代表剩余点数（5个相同就剩余1个，4个相同就剩余2个)
 * 状元规则：
 * 1-五个点数相同为状元，剩余一个点数为module值
 * 2-四个点数相同并且满足以下规则的是状元
 *  * 4个4 -- 3+1  --21（定义的特殊module）
 *  * 4个6 -- 4+2  --20
 *  * 4个5 -- 4+1  --19
 *  * 4个4 -- 2+2  --18
 *  * 4个5 -- 2+3  --17
 *  * 4个6 -- 5+1  --16
 *  * 4个3 -- 2+1  --15
 *  * 4个6 -- 3+3  --14
 *  * 4个2 -- 1+1  --13
 *  * 4个4 -- 2 --12/（1+3 2+2除外，剩余点数相加为module的值）
 *  状元规则：四个点数状元< 五个点数状元，四个点数状元之间，module越大状元越大
 * @author biogss
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
