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
public class NullDiscount implements Discount{
    private String typeDiscount = "NoDiscount";
    
    public NullDiscount(String typeDiscount) {
        if (typeDiscount != null) {
            this.typeDiscount = typeDiscount;
        }
    }

    @Override
    public String getDiscount() {
        return typeDiscount;
    }

    @Override
    public float apply(float discount) {
        return discount * 0;
    }
}
