/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper.categoryClothes;

/**
 *
 * @author asus
 */
public class CategoryClothesFactory {
    private CategoryClothesFactory() {
    }
    
    public static final CategoryClothes getCategory(ClothesType clothesType) {
        switch (clothesType) {
            case BLOUSE:
                return new Blouse();

            case DRESS:
                return new Dress();

            case JACKET:
                return new Jacket();
            
            case SKIRT:
                return new Skirt();
                
            case SWEATER:
                return new Sweater();
                
            case WINTERDRESS:
                return new WinterDress();    
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    
    }
}
