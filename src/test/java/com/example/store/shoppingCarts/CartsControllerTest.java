package com.example.store.shoppingCarts;

import com.alibaba.fastjson.JSONObject;
import com.example.store.shoppingcarts.CartProduct;
import com.example.store.shoppingcarts.CartService;
import com.example.store.shoppingcarts.CartsController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CartsController.class)
@ContextConfiguration()
public class CartsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    public void should_add_cart_products_to_cart_when_post_request() throws Exception {
        List<CartProduct> cart = new ArrayList<>();

        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(1);
        cartProduct.setQuantity(3);
        cart.add(cartProduct);

        CartProduct cartProduct1 = new CartProduct();
        cartProduct1.setProductId(2);
        cartProduct1.setQuantity(4);
        cart.add(cartProduct1);

        String cartJSON = JSONObject.toJSONString(cart);

        given(cartService.addToCart(Mockito.anyList())).willReturn(cart);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/1/shoppingcarts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cartJSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productId").value(1))
                .andExpect(jsonPath("$[1].productId").value(2));

    }
}