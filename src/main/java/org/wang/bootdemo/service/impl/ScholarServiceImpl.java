package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.model.Chip;
import org.wang.bootdemo.model.MaxScholar;
import org.wang.bootdemo.service.ScholarService;

import java.util.*;

/**
 * 获取状元结果实例 五子以下状元定义级别
 * 4个4 -- 3+1  --21
 * 4个6 -- 4+2  --20
 * 4个5 -- 4+1  --19
 * 4个4 -- 2+2  --18
 * 4个5 -- 2+3  --17
 * 4个6 -- 5+1  --16
 * 4个3 -- 2+1  --15
 * 4个6 -- 3+3  --14
 * 4个2 -- 1+1  --13
 * 4个4 -- *2 --12/（1+3 2+2）
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

    @Autowired
    private Chip chip;

    @Autowired
    public void setMaxScholar(MaxScholar maxScholar){
        this.maxScholar = maxScholar;
    }

    /**
     *四红的大小等级
     */
    private int fourRedRank;

    /**
     * 扔骰子
     */
    @Override
    public String rengShaiZi(){
        //每次清零
        reset();
        for (int i = 0; i < 6; i++) {
            //每次的点数
            int num = (int) (Math.random() * 6) + 1;
            //总点数
            total += num;
            box.add(num);
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
        System.out.println("扔骰子结果：" + listToString(box));
        System.out.println("a1=" + a1 + ",a2=" + a2 + ",a3=" + a3 + ",a4=" + a4 + ",a5=" + a5 + ",a6=" + a6);

        //辅助判断对子
        List<Integer> alist = new ArrayList<>();
        alist.add(a1);
        alist.add(a2);
        alist.add(a3);
        alist.add(a4);
        alist.add(a5);
        alist.add(a6);

        //判断结果--全红
        if (a4 == 6) {
            return "全红";
        }
        //--全黑
        if (a1 == 6 || a2 == 6 || a3 == 6 || a5 == 6 || a6 == 6) {
            return "全黑";
        }
        //--五红
        if (a4 == 5) {
            //计算状元点数
            int m = total - 5 * 4;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 4, m);
                return "最先获得状元";
            }else {
                //已经存在状元，5个4点并且剩余点数大于当前剩余点数，不能夺状元
              if (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4 &&
              maxScholar.getModule() >= m) {
                  //发牌16点
                  chip.distributeRule(16);
                  return "夺状元失败,获得大小王";
              }else {
                  //存储最大的状元
                  maxScholar.setMax(5, 4, m);
                  return "点数更大，夺取状元";
              }
            }
        }
        //五个一
        else if (a1 == 5){
            //计算状元点数
            int m = total - 5;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 1, m);
                return "最先获得状元";
            }else {
                //如果5个1带红（5个1点,1个4点）
                if (m == 4) {
                    //存在状元，5个x（x>=1）并且剩余点数挂红（4点） 或者 5个4点
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() >= 1 && maxScholar.getModule() == 4) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 1, m);
                        return "点数更大，夺取状元";
                    }
                }else {
                    //5个x（x>1）或者5个1并且以前剩余点数大于当前的剩余点数或者5个x带红
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() > 1) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 1 && maxScholar.getModule() >= m) ||
                            (maxScholar.getNum() == 5 && maxScholar.getModule() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 1, m);
                        return "点数更大，夺取状元";
                    }
                }
            }
        }
        //五个二
        else if (a2 == 5){
            //计算状元点数
            int m = total - 5 * 2;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 2, m);
                return "最先获得状元";
            }else {
                //如果5个2带红（5个2点,1个4点）
                if (m == 4) {
                    //存在状元，5个x（x>=2）并且剩余点数挂红（4点） 或者 5个4点
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() >= 2 && maxScholar.getModule() == 4) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 2, m);
                        return "点数更大，夺取状元";
                    }
                }else {
                    //5个x（x>2）或者5个2并且以前剩余点数大于当前的剩余点数 或者 5个x并且带红（4点）
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() > 2) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 2 && maxScholar.getModule() >= m) ||
                            (maxScholar.getNum() == 5 && maxScholar.getModule() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 2, m);
                        return "点数更大，夺取状元";
                    }
                }
            }
        }
        //五个三
        else if (a3 == 5){
            //计算状元点数
            int m = total - 5 * 3;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 3, m);
                return "最先获得状元";
            }else {
                //如果5个2带红（5个2点,1个4点）
                if (m == 4) {
                    //存在状元，5个x（x>=3）并且剩余点数挂红（4点） 或者 5个4点
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() >= 3 && maxScholar.getModule() == 4) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 3, m);
                        return "点数更大，夺取状元";
                    }
                }else {
                    //5个x（x>3）或者5个3并且以前剩余点数大于当前的剩余点数 或者 5个x并且带红（4点）
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() > 3) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 3 && maxScholar.getModule() >= m)
                            || (maxScholar.getNum() == 5 && maxScholar.getModule() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 3, m);
                        return "点数更大，夺取状元";
                    }
                }
            }
        }
        //五个五
        else if (a5 == 5){
            //计算状元点数
            int m = total - 5 * 5;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 5, m);
                return "最先获得状元";
            }else {
                //如果5个2带红（5个2点,1个4点）
                if (m == 4) {
                    //存在状元，5个x（x>=5）并且剩余点数挂红（4点） 或者 5个4点
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() >= 5 && maxScholar.getModule() == 4) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 5, m);
                        return "点数更大，夺取状元";
                    }
                }else {
                    //5个x（x>5）或者5个5并且以前剩余点数大于当前的剩余点数 或者 5个x并且带红（4点）
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() > 5) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 5 && maxScholar.getModule() >= m)
                            || (maxScholar.getNum() == 5 && maxScholar.getModule() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 5, m);
                        return "点数更大，夺取状元";
                    }
                }
            }
        }
        //五个六
        else if (a6 == 6){
            //计算状元点数
            int m = total - 5 * 6;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(5, 6, m);
                return "最先获得状元";
            }else {
                //如果5个2带红（5个2点,1个4点）
                if (m == 4) {
                    //存在状元，5个x（x>=6）并且剩余点数挂红（4点） 或者 5个4点
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() >= 6 && maxScholar.getModule() == 4) ||
                            (maxScholar.getNum() == 5 && maxScholar.getPoint() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 6, m);
                        return "点数更大，夺取状元";
                    }
                }else {
                    //5个x（x>6）或者5个6并且以前剩余点数大于当前的剩余点数 或者 5个x并且带红（4点）
                    if ((maxScholar.getNum() == 5 && maxScholar.getPoint() == 6 && maxScholar.getModule() >= m) ||
                            (maxScholar.getNum() == 5 && maxScholar.getModule() == 4)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    } else {
                        //存储最大的状元
                        maxScholar.setMax(5, 6, m);
                        return "点数更大，夺取状元";
                    }
                }
            }
        }

        //四个四
        else if (a4 == 4) {
            //计算状元点数
            int m = total - 4 * 4;
            //将状元放到状元盒子
            ScholarList.add(listToString(box));
            //计算4红的等级，值越大等级越高
            if (m == 4) {
                if (a3 == 1 && a1 == 1) {
                    fourRedRank = 21;
                }else if (a2 == 2){
                    fourRedRank = 18;
                }
            }else {
                fourRedRank = total - 4 * 4;
            }
            //判断是否可以夺状元
            if (maxScholar.getNum() < 4){
                //此前没有状元
                maxScholar.setMax(4, 4, fourRedRank);
                return "最先获得状元";
            }else {
                //5红或者4红等级更高
                if (maxScholar.getNum() == 5 ||
                        (maxScholar.getNum() == 4 && maxScholar.getModule() >= fourRedRank)) {
                    //发牌16点
                    chip.distributeRule(16);
                    return "夺状元失败，获得大小王";
                }else {
                    maxScholar.setMax(4, 4, fourRedRank);
                    return "点数更大，夺取状元";
                }
            }
        }
        //四个1
        else if (a1 == 4) {
            //发牌4点
            chip.distributeRule(4);
            if (a4 == 1) {
              //发牌1点
              chip.distributeRule(1);
              return "筷子+小狗";
          }else if (a4 == 2) {
              //发牌2点
              chip.distributeRule(2);
              return "筷子+大狗";
          }else {
              return "筷子";
          }
        }

        //四个二
        else if (a2 == 4) {
            //判断是否状元
            if(a1 == 2) {
                //将状元放到状元盒子
                ScholarList.add(listToString(box));
                //计算4红的等级，值越大等级越高
                fourRedRank = 13;
                //判断是否可以夺状元
                if (maxScholar.getNum() < 4){
                    //此前没有状元
                    maxScholar.setMax(4, 1, fourRedRank);
                    return "最先获得状元";
                }else {
                    //5红或者4红等级更高
                    if (maxScholar.getNum() == 5 ||
                            (maxScholar.getNum() == 4 && maxScholar.getModule() >= fourRedRank)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    }else {
                        maxScholar.setMax(4, 1, fourRedRank);
                        return "点数更大，夺取状元";
                    }
                }
            } else {
                //发牌4点
                chip.distributeRule(4);
                if (a4 == 1) {
                    //发牌1点
                    chip.distributeRule(1);
                    return "筷子+小狗";
                }else if (a4 == 2) {
                    //发牌2点
                    chip.distributeRule(2);
                    return "筷子+大狗";
                }else {
                    return "筷子";
                }
            }
        }

        //四个三
        else if (a3 == 4) {
            //判断是否状元
            if((total - 4 * 3) == 3) {
                //将状元放到状元盒子
                ScholarList.add(listToString(box));
                //计算4红的等级，值越大等级越高
                fourRedRank = 15;
                //判断是否可以夺状元
                if (maxScholar.getNum() < 4){
                    //此前没有状元
                    maxScholar.setMax(4, 3, fourRedRank);
                    return "最先获得状元";
                }else {
                    //5红或者4红等级更高
                    if (maxScholar.getNum() == 5 ||
                            (maxScholar.getNum() == 4 && maxScholar.getModule() >= fourRedRank)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败,获得大小王";
                    }else {
                        maxScholar.setMax(4, 3, fourRedRank);
                        return "点数更大，夺取状元";
                    }
                }
            } else {
                //发牌4点
                chip.distributeRule(4);
                if (a4 == 1) {
                    //发牌1点
                    chip.distributeRule(1);
                    return "筷子+小狗";
                }else if (a4 == 2) {
                    //发牌2点
                    chip.distributeRule(2);
                    return "筷子+大狗";
                }else {
                    return "筷子";
                }
            }
        }

        //四个五
        else if (a5 == 4) {
            //计算状元点数
            int m = total - 4 * 5;
            if (m == 5) {
                //将状元放到状元盒子
                ScholarList.add(listToString(box));
                //计算4红的等级，值越大等级越高
                if (a4 == 1 && a1 == 1) {
                    fourRedRank = 19;
                }else if (a2 == 1 && a3 == 1){
                    fourRedRank = 17;
                }
                //判断是否可以夺状元
                if (maxScholar.getNum() < 4){
                    //此前没有状元
                    maxScholar.setMax(4, 5, fourRedRank);
                    return "最先获得状元";
                }else {
                    //5红或者4红等级更高
                    if (maxScholar.getNum() == 5 ||
                            (maxScholar.getNum() == 4 && maxScholar.getModule() >= fourRedRank)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    }else {
                        maxScholar.setMax(4, 5, fourRedRank);
                        return "点数更大，夺取状元";
                    }
                }
            } else {
                //发牌4点
                chip.distributeRule(4);
                if (a4 == 1) {
                    //发牌1点
                    chip.distributeRule(1);
                    return "筷子+小狗";
                }else if (a4 == 2) {
                    //发牌2点
                    chip.distributeRule(2);
                    return "筷子+大狗";
                }else {
                    return "筷子";
                }
            }
        }

        //四个6
        else if (a6 == 4) {
            //计算状元点数
            int m = total - 4 * 6;
            if (6 == m) {
                //将状元放到状元盒子
                ScholarList.add(listToString(box));
                //计算4红的等级，值越大等级越高
                if (a4 == 1 && a2 == 1) {
                    fourRedRank = 20;
                }else if (a1 == 1 && a5 == 1){
                    fourRedRank = 16;
                }else if (a3 == 2){
                    fourRedRank = 14;
                }
                //判断是否可以夺状元
                if (maxScholar.getNum() < 4){
                    //此前没有状元
                    maxScholar.setMax(4, 6, fourRedRank);
                    return "最先获得状元";
                }else {
                    //5红或者4红等级更高
                    if (maxScholar.getNum() == 5 ||
                            (maxScholar.getNum() == 4 && maxScholar.getModule() >= fourRedRank)) {
                        //发牌16点
                        chip.distributeRule(16);
                        return "夺状元失败，获得大小王";
                    }else {
                        maxScholar.setMax(4, 6, fourRedRank);
                        return "点数更大，夺取状元";
                    }
                }
            } else {
                //发牌4点
                chip.distributeRule(4);
                if (a4 == 1) {
                    //发牌1点
                    chip.distributeRule(1);
                    return "筷子+小狗";
                }else if (a4 == 2) {
                    //发牌2点
                    chip.distributeRule(2);
                    return "筷子+大狗";
                }else {
                    return "筷子";
                }
            }
        }
        //三个4
        else if(a4 == 3) {
            if (a1 == 3 || a2 ==3 || a3 == 3 || a5 == 3 || a6 == 3) {
                //发牌16点
                chip.distributeRule(16);
                return "三红对，大小王";
            }else if ((total - 3 * 4) == 5) {
                //发牌16点
                chip.distributeRule(16);
                return "三红垛子，大小王";
            } else {
                //发牌8点
                chip.distributeRule(8);
                return "三红-AAA";
            }
        }
        //三个1
        else if (a1 == 3) {
            if (a2 ==3 || a3 == 3 || a5 == 3 || a6 == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "粉的--筷子";
            } else if ((total - 3) == 5){
                //发牌4点
                chip.distributeRule(4);
                return "垛子--筷子";
            }else if ((total - 3) == 4) {
                //TODO 引入用户后处理
                chip.blind();
                return "瞎子";
            }else if (a4 == 2){
                //发牌2点
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            }else {
                //发牌4点
                chip.distributeRule(0);
                return "零红";
            }
        }

        //三个2
        else if (a2 == 3) {
            if (a1 ==3 || a3 == 3 || a5 == 3 || a6 == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "粉的--筷子";
            } else if ((total - 3 * 2) == 5){
                //发牌4点
                chip.distributeRule(4);
                return "垛子--筷子";
            }else if ((total - 3 * 2) == 4) {
                chip.blind();
                return "瞎子";
            }else if (a4 == 2){
                //发牌2点
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            }else {
                //发牌0点
                chip.distributeRule(0);
                return "零红";
            }
        }

        //三个3
        else if (a3 == 3) {
            if (a1 ==3 || a2 == 3 || a5 == 3 || a6 == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "粉的--筷子";
            } else if ((total - 3 * 3) == 5){
                //发牌4点
                chip.distributeRule(4);
                return "垛子";
            }else if ((total - 3 * 3) == 4) {
                chip.blind();
                return "瞎子";
            }else if (a4 == 2){
                //发牌2点
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            }else {
                //发牌0点
                chip.distributeRule(0);
                return "零红";
            }
        }

        //三个5
        if (a5 == 3) {
            if (a1 ==3 || a2 == 3 || a3 == 3 || a6 == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "筷子";
            } else if ((total - 3 * 5) == 5){
                //发牌4点
                chip.distributeRule(4);
                //垛子
                return "垛子";
            }else if ((total - 3 * 5) == 4) {
                chip.blind();
                return "瞎子";
            }else if (a4 == 2){
                //发牌2点
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            }else {
                //发牌0点
                chip.distributeRule(0);
                return "零红";
            }
        }

        //三个6
        else if (a6 == 3) {
            if (a1 ==3 || a2 == 3 || a3 == 3 || a5 == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "筷子";
            } else if ((total - 3 * 6) == 5){
                //发牌4点
                chip.distributeRule(4);
                //垛子
                return "垛子";
            }else if ((total - 3 * 6) == 4) {
                chip.blind();
                return "瞎子";
            }else if (a4 == 2){
                //发牌2点
                chip.distributeRule(2);
                return "二红";
            }else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            }else {
                //发牌4点
                chip.distributeRule(0);
                return "零红";
            }
        }

        //两个4
        else if (a4 == 2) {
            if (a5 == 2 && a6 == 2) {
                //发牌16点
                chip.distributeRule(16);
                return "456大小王";
            }else {
                if (Collections.frequency(alist, 2) == 3) {
                    //发牌8点
                    chip.distributeRule(8);
                    return "二红对AAA";
                }else {
                    //发牌2点
                    chip.distributeRule(2);
                    return "二红";
                }
            }
        }

        //两个1,2,3,4,5,6
        else if (a1 == 2 || a2 == 2 || a3 == 2 || a5 == 2 || a6 == 2) {
            if (Collections.frequency(alist, 2) == 3) {
                //发牌4点
                chip.distributeRule(4);
                return "筷子";
            } else if (a4 == 1) {
                //发牌1点
                chip.distributeRule(1);
                return "一红";
            } else {
                //发牌0点
                chip.distributeRule(0);
                return "零红";
            }
        }
        else {
            //发牌16点
            chip.distributeRule(16);
            return "顺子";
        }
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
        a1 = 0;
        a2 = 0;
        a3 = 0;
        a4 = 0;
        a5 = 0;
        a6 = 0;
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

    private void faPai(int point){

    }
}
