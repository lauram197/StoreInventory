package StoreInventoryMV.controller;

import controller.StoreController;
import junit.framework.TestCase;
import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Laura on 14.04.2018.
 */
public class WBT extends TestCase {
    private StoreController ctrl;
    private String emptyMessage = "Id, Name or address cannot be empty!";

    @Before
    public void setUp() throws Exception{
        super.setUp();

        ctrl = new StoreController();

    }

    @Test
    public void testCategory1() throws Exception {


        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(2,"b","a",2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 2);
    }

    public void testCategory2() throws Exception {


        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(2,"b","a",2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertFalse("The producted was added", productList.size() == 1);
    }

    public void testCategory3() throws Exception {

    //duplicate code
        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(1,"b","a",2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was added", productList.size() == 1);
    }

    public void testCategory4() throws Exception {

    //code negative
        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(-10,"b","a",2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was added", productList.size() == 1);
    }

    public void testCategory5() throws Exception {

        //quantity negative
        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(10,"b","a",-2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.getProductsCategory("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was added", productList.size() == 1);
    }

    public void testStockSituation() throws Exception {

        //quantity negative
        Product p1=new Product(1,"a","a",1);
        Product p2=new Product(10,"b","a",-2);
        ctrl.addProduct(p1);
        ctrl.addProduct(p2);
        List<Product> productList = ctrl.stockSituationProduct("a");
        System.out.println(productList.size());
        Assert.assertTrue("The producted was added", productList.size() == 1);
    }

}
