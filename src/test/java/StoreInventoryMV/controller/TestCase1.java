package StoreInventoryMV.controller;

import controller.StoreController;
import junit.framework.TestCase;
import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Laura on 29.03.2018.
 */
public class TestCase1 extends TestCase{

    private StoreController ctrl;
    private String emptyMessage = "Id, Name or address cannot be empty!";

    @Before
    public void setUp() throws Exception{
        super.setUp();

        ctrl = new StoreController();
        //add a client with a normal name
        //Product p1=new Product(1,"a","a",1);
        //ctrl.addProduct(p1);
        //add a client with a name with spaces
        //Product p2=new Product(2,"b","b",1);
        //ctrl.addProduct(p2);

    }

    @Test
    public void testAddProduct1() throws Exception {

        //name is empty
        Product p1=new Product(1,"a","a",1);
        ctrl.addProduct(p1);
        List<Product> productList = ctrl.stockSituation();
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 1);
    }

    @Test
    public void testAddProduct2() throws Exception {

        //name is empty
        Product p1=new Product(1,"","a",1);
        ctrl.addProduct(p1);
        List<Product> productList = ctrl.stockSituation();
        System.out.println(productList.size());
        Assert.assertTrue("The producted was not added", productList.size() == 1);
    }


}
