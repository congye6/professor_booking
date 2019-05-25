package cn.edu.nju.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScaleUtil {

    /**
     * 保留n位小数
     *
     * @param scale 小数的位数
     * @return
     */
    public static double scale(int scale, double num) {
        BigDecimal decimal = new BigDecimal(num);
        decimal = decimal.setScale(scale, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }

}
