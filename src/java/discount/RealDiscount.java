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
public class RealDiscount implements Discount{
    private String typeDiscount;
    private float percentDiscount;
 
    public RealDiscount(String typeDiscount, float percentDiscount) {
        this.typeDiscount = typeDiscount;
        this.percentDiscount = percentDiscount;
    }
 
    @Override
    public String getDiscount() {
        return typeDiscount;
    }

    @Override
    public float apply(float discount) {
        return percentDiscount * discount;
    }
    
}
