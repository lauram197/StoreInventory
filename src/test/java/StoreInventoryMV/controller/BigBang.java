package StoreInventoryMV.controller;

import controller.StoreController;
import junit.framework.TestCase;
import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Laura on 18.04.2018.
 */
public class BigBang extends TestCase {
    private StoreController ctrl;
    private String emptyMessage = "Id, Name or address cannot be empty!";

    @Before
    public void setUp() throws Exception{
        super.setUp();

        ctrl = new StoreController();

    }

    @Test
    public void testInterg1() throws Exception {


        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(2,"b","a",2);
        ctrl.addProduct(p2);
        ctrl.addProduct(p1);
        List<Product> productList = ctrl.stockSituation();
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 2);


        ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 2);


        Product p3=new Product(3,"a","a",5);

        ctrl.addProduct(p3);
        ctrl.stockSituationProduct("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 3);
    }

}
