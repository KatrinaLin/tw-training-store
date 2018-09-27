package com.example.store;

import com.example.store.orders.Order;
import com.example.store.orders.OrderController;
import com.example.store.orders.OrderProduct;
import com.example.store.orders.OrderService;
import com.example.store.products.Product;
import com.example.store.products.ProductController;
import com.example.store.products.ProductService;
import com.example.store.shoppingcarts.CartProduct;
import com.example.store.shoppingcarts.CartService;
import com.example.store.shoppingcarts.CartsController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {StoreApplication.class})
@WebMvcTest(value = {ProductController.class, CartsController.class, OrderController.class})
public abstract class MvcTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        given(productService.getProducts()).willReturn(getProductList());
        given(cartService.addToCart(Mockito.anyList())).willReturn(getShoppingCart());
        given(orderService.createOrder(Mockito.anyList())).willReturn(getOrder());
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    private Order getOrder() {
        Order order = new Order();
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>();
        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setProductId(1);
        orderProduct1.setQuantity(3);

        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setProductId(2);
        orderProduct2.setQuantity(4);

        orderProductList.add(orderProduct1);
        orderProductList.add(orderProduct2);

        order.setProductList(orderProductList);
        return order;
    }

    private List<Product> getProductList() {
        ArrayList<Product> products = new ArrayList<>();

        Product product = new Product();
        product.setId(1);
        product.setName("可乐");
        product.setPrice(BigDecimal.valueOf(4.5));
        product.setUnit("瓶");
        product.setTotalAmount(100);
        product.setImgUrl("/api/img/1");

        Product product1 = new Product();
        product1.setId(2);
        product1.setName("雪碧");
        product1.setPrice(BigDecimal.valueOf(4.5));
        product1.setUnit("罐");
        product1.setTotalAmount(10);
        product1.setImgUrl("/api/img/2");

        products.add(product);
        products.add(product1);

        return products;
    }

    private List<CartProduct> getShoppingCart() {
        List<CartProduct> cart = new ArrayList<>();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(1);
        cartProduct.setQuantity(3);
        cart.add(cartProduct);

        CartProduct cartProduct1 = new CartProduct();
        cartProduct1.setProductId(2);
        cartProduct1.setQuantity(4);
        cart.add(cartProduct1);

        return cart;
    }


}
