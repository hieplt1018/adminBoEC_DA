/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package discount;

/**
 *
 * @author asus
 */
public class DiscountUses {
    public float getDiscount(float discount, String typeDiscount) {
        Discount discount1 = DiscountFactory.getDiscountByType(typeDiscount);
        return discount1.apply(discount);
    }
}
