/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package discount;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author asus
 */
public class DiscountFactory {
    private static final Map<String, Float> DISCOUNT = new HashMap<>();
 
    static {
        DISCOUNT.put("NewYear", Float.parseFloat("20"));
        DISCOUNT.put("Chirstmas", Float.parseFloat("20"));
        DISCOUNT.put("BlackFriday", Float.parseFloat("25"));
        DISCOUNT.put("Vip", Float.parseFloat("25"));
    }
 
    public static Discount getDiscountByType(String discountType) {
        float percentDiscount = DISCOUNT.get(discountType);
        if (discountType != null) {
            return new RealDiscount(discountType, percentDiscount);
        }
        return new NullDiscount(discountType);
    }
}
