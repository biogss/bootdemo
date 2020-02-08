package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.constants.Constant;
import org.wang.bootdemo.model.Chip;
import org.wang.bootdemo.model.MaxScholar;
import org.wang.bootdemo.service.ScholarService;

import java.util.*;

/**
 * @author biogss
 */
@Service
public class ScholarServiceImpl implements ScholarService {

    /**
     * 存放点数1的盒子
     */
    private int a1 = 0;

    /**
     * 存放点数2的盒子
     */
    private int a2 = 0;

    /**
     * 存放点数3的盒子
     */
    private int a3 = 0;

    /**
     * 存放点数4的盒子
     */
    private int a4 = 0;

    /**
     * 存放点数5的盒子
     */
    private int a5 = 0;

    /**
     * 存放点数6的盒子
     */
    private int a6 = 0;

    /**
     * 存放所有点数的盒子
     */
    private List<Integer> box = new ArrayList<>(6);

    /**
     * 总点数
     */
    private int total = 0;

    /**
     * 存放所有的状元
     */
    private List<String> ScholarList = new ArrayList<>();

    /**
     * 记录最大的状元
     */
    private MaxScholar maxScholar;

    private Chip chip;

    @Autowired
    public void setChip(Chip chip) {
        this.chip = chip;
    }

    @Autowired
    public void setMaxScholar(MaxScholar maxScholar){
        this.maxScholar = maxScholar;
    }

    /**
     *四红的大小等级
     */
    private int fourRedRank;

    /**
     * 将各个点数的个数a1-a6放到list中，用于数据判断
     */
    List<Integer> alist = new ArrayList<>();

    /**
     * 扔骰子
     */
    @Override
    public String throwDice(){
        //每次扔骰子先清零总数，盒子，各个点数的个数
        reset();
        //计算总点数，并放到盒子中，计算各个点数个数
        producePoint();
        //判断结果--全红 6个4点
        if (a4 == Constant.numSix) {
            return "全红";
        }
        //--全黑 6个1或2或3或5或6
        if (a1 == Constant.numSix || a2 == Constant.numSix ||
                a3 == Constant.numSix || a5 == Constant.numSix || a6 == Constant.numSix) {
            return "全黑";
        }
        //判断5个相同点数逻辑
        if (a4 == Constant.numFive) {
            return fivePoint(Constant.pointFour);
        }else if (a1 == Constant.numFive) {
            return fivePoint(Constant.pointOne);
        }else if (a2 == Constant.numFive) {
            return fivePoint(Constant.pointTwo);
        }else if (a3 == Constant.numFive) {
            return fivePoint(Constant.pointThree);
        }else if (a5 == Constant.numFive) {
            return fivePoint(Constant.pointFive);
        }else if (a6 == Constant.numFive) {
            return fivePoint(Constant.pointSix);
        }
        //判断4个相同点逻辑
        if (a4 == Constant.numFour) {
            return fourPoint(4);
        }else if (a1 == Constant.numFour) {
            return fourPoint(1);
        }else if (a2 == Constant.numFour) {
            return fourPoint(2);
        }else if (a3 == Constant.numFour) {
            return fourPoint(3);
        }else if (a5 == Constant.numFour) {
            return fourPoint(5);
        }else if (a6 == Constant.numFour) {
            return fourPoint(6);
        }
        //三个4
        if(a4 == Constant.numThree) {
            return threePoint(4);
        } else if (a1 == Constant.numThree) {
            return threePoint(1);
        }else if (a2 == Constant.numThree) {
            return threePoint(2);
        }else if (a3 == Constant.numThree) {
            return threePoint(3);
        }else if (a5 == Constant.numThree) {
            return threePoint(5);
        }else if (a6 == Constant.numThree) {
            return threePoint(6);
        }
        //两个4
        if (a4 == Constant.numTwo) {
            if (a5 == Constant.numTwo && a6 == Constant.numTwo) {
                chip.distributeRule(16);
                return "456大小王";
            }else {
                if (Collections.frequency(alist, Constant.numTwo) == Constant.numThree) {
                    chip.distributeRule(8);
                    return "二红对AAA";
                }else {
                    chip.distributeRule(2);
                    return "二红";
                }
            }
        }
        //两个1,2,3,4,5,6
        if (a1 == Constant.numTwo || a2 == Constant.numTwo ||
                a3 == Constant.numTwo || a5 == Constant.numTwo ||
                a6 == Constant.numTwo) {
            if (Collections.frequency(alist, Constant.numTwo) == Constant.numThree) {
                chip.distributeRule(4);
                return "筷子";
            } else if (a4 == 1) {
                chip.distributeRule(1);
                return "一红";
            } else {
                return "零红";
            }
        }
        chip.distributeRule(16);
        return "顺子";
    }

    /**
     * 5个相同点数逻辑
     */
    private String fivePoint(int point) {
        //计算状元点数
        int m = total - 5 * point;
        //将状元放到状元盒子
        ScholarList.add(listToString(box));
        //判断是否可以夺状元
        if (maxScholar.getNum() <= Constant.numFour){
            maxScholar.setMax(5, point, m);
            return "获得状元";
        }else if (maxScholar.getNum() == Constant.numFive){
            //已经存在5个相同点数状元
            if (point == Constant.pointFour) {
                //5个四点的规则：5个4点并且剩余点数大于当前剩余点数，不能夺状元
                if (maxScholar.getPoint() == Constant.pointFour &&
                        maxScholar.getModule() >= m) {
                    //夺状元失败，按照16点发牌
                    chip.distributeRule(16);
                    return "夺取状元失败";
                }else {
                    //存储最大的状元
                    maxScholar.setMax(5, point, m);
                    return "获得状元";
                }
            }else {
                //5个x带红（5个x点,1个4点）
                if (m == Constant.pointFour) {
                    //存在状元，5个x(x>=当前point)并且剩余点数挂红（4点） 或者 5个4点
                    boolean isSmaller = (maxScholar.getPoint() >= point && maxScholar.getModule() == 4) ||
                            (maxScholar.getPoint() == 4);
                    if (isSmaller) {
                        //夺状元失败，按照16点发牌
                        chip.distributeRule(16);
                        return "夺取状元失败";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, point, m);
                        return "获得状元";
                    }
                }else {
                    //5个x或者5个3并且以前剩余点数大于当前的剩余点数 或者 5个x并且带红（4点）
                    boolean isSmaller = (maxScholar.getPoint() > point) ||
                            (maxScholar.getPoint() == point && maxScholar.getModule() >= m) ||
                            (maxScholar.getModule() == 4);
                    if (isSmaller) {
                        //夺状元失败，按照16点发牌
                        chip.distributeRule(16);
                        return "夺取状元失败";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, point, m);
                        return "获得状元";
                    }
                }
            }
        }
        return "夺取状元失败";
    }

    /**
     * 4个相同点数逻辑
     */
    private String fourPoint(int point){
        //计算状元点数
        int m = total - 4 * point;
        //满足此规则是状元
        if (m == point || point == Constant.numFour) {
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //计算4个相同点数状元等级，值越大状元越大
            fourRedRank = calculateScholarRank(point);
            //判断是否可以夺取状元
            if (maxScholar.getNum() < Constant.numFour){
                //此前没有状元
                maxScholar.setMax(4, point, fourRedRank);
                return "获得状元";
            }else {
                //5红或者4红等级更高
                boolean isSmaller = (maxScholar.getNum() == Constant.numFive) ||
                        (maxScholar.getNum() == Constant.numFour && maxScholar.getModule() >= fourRedRank);
                if (isSmaller) {
                    //夺状元失败，按照16点发牌
                    chip.distributeRule(16);
                    return "夺取状元失败";
                }else {
                    maxScholar.setMax(4, point, fourRedRank);
                    return "获得状元";
                }
            }
        }else {
            //发牌4点
            chip.distributeRule(4);
            if (a4 == Constant.numOne) {
                //发牌1点
                chip.distributeRule(1);
                return "筷子+小狗";
            }else if (a4 == Constant.numTwo) {
                //发牌2点
                chip.distributeRule(2);
                return "筷子+大狗";
            }else {
                return "筷子";
            }
        }
    }

    private int calculateScholarRank(int point) {
        int result = 0;
        if (point == Constant.pointSix) {
            if (a4 == Constant.numOne && a2 == Constant.numOne) {
                result = 20;
            }else if (a1 == Constant.numOne && a5 == Constant.numOne){
                result = 16;
            }else if (a3 == Constant.numTwo){
                result = 14;
            }
        }else if (point == Constant.pointFive) {
            if (a4 == Constant.numOne && a1 == Constant.numOne) {
                result = 19;
            }else if (a2 == Constant.numOne && a3 == Constant.numOne){
                result = 17;
            }
        }else if (point == Constant.pointThree) {
            result = 15;
        }else if (point == Constant.pointTwo) {
            result = 13;
        }else if (point == Constant.pointFour) {
            if (a3 == Constant.numOne && a1 == Constant.numOne) {
                result = 21;
            }else if (a2 == Constant.numTwo){
                result = 18;
            }else {
                result = total - 4 * 4;
            }
        }
        return result;
    }

    /**
     * 3个相同点数逻辑
     */
    private String threePoint(int point) {
        int m = total - 3 * point;
        if (point == Constant.pointFour) {
            if (Collections.frequency(alist, Constant.numThree) == Constant.numTwo) {
                chip.distributeRule(16);
                return "三红对，大小王";
            }else if (m == Constant.pointFive) {
                chip.distributeRule(16);
                return "三红垛子";
            }else {
                chip.distributeRule(8);
                return "三红-AAA";
            }
        }else {
            if (Collections.frequency(alist, Constant.numThree) == Constant.numTwo) {
                chip.distributeRule(4);
                return "粉的--筷子";
            }else if (m == Constant.pointFive) {
                chip.distributeRule(4);
                return "垛子";
            }else if (m == Constant.pointFour) {
                chip.blind();
                return "瞎子";
            }else if (a4 == Constant.numTwo) {
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == Constant.numOne) {
                chip.distributeRule(1);
                return "一红";
            }else {
                return "零红";
            }
        }
    }
    private void producePoint() {
        //6个骰子，所以循环6次
        for (int i = 0; i < 6; i++) {
            //每次通过随机数生成点数
            int num = (int) (Math.random() * 6) + 1;
            //总点数
            total += num;
            //使用盒子存在此次骰子点数
            box.add(num);
            //计算点数的个数
            switch (num) {
                case 1:
                    ++a1;
                    break;
                case 2:
                    ++a2;
                    break;
                case 3:
                    ++a3;
                    break;
                case 4:
                    ++a4;
                    break;
                case 5:
                    ++a5;
                    break;
                case 6:
                    ++a6;
                    break;
                default:
            }
        }
        //将各个点数的个数a1-a6放到list中，用于数据判断
        alist.add(a1);
        alist.add(a2);
        alist.add(a3);
        alist.add(a4);
        alist.add(a5);
        alist.add(a6);
        System.out.println("扔骰子结果：" + listToString(box));
        System.out.println("a1=" + a1 + ",a2=" + a2 + ",a3=" + a3 + ",a4=" + a4 + ",a5=" + a5 + ",a6=" + a6);
    }

    /**
     * 打印状元记录
     */
    public void printScholars(){
        System.out.println("状元流水为：");
        for (String scholar : ScholarList) {
            System.out.println(scholar);
        }
    }

    public void printMaxScholar(){
        System.out.println("最终状元结果为：" + maxScholar.getNum() + "," + maxScholar.getPoint() + "," + maxScholar.getModule());
    }

    /**
     * 每次扔骰子先清零
     */
    private void reset() {
        this.total = 0;
        box.clear();
        alist.clear();
        a1 = a2 = a3 = a4 = a5 = a6 = 0;
    }

    /**
     * 对list进行排序，并且转化为字符串
     * @param list
     * @return
     */
    private String listToString(List<Integer> list) {
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i) + ",");
        }
        sb.append(list.get(list.size() - 1) + "");
        return sb.toString();
    }
}
