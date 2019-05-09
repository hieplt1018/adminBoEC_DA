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
public interface Discount {
    String getDiscount();
 
    float apply(float discount);
}
