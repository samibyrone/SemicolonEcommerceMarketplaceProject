package com.semicolon.africa.utils;

import com.semicolon.africa.data.model.CartItem;
import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.model.ShoppingCart;
import com.semicolon.africa.data.model.User;
import com.semicolon.africa.dtos.requests.*;
import com.semicolon.africa.dtos.responses.*;

public class Mapper {

    public static void map(UserRegisterRequest userRegisterRequest, User user) {
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setUserName(userRegisterRequest.getUserName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setAddress(userRegisterRequest.getAddress());
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        user.setPassword(userRegisterRequest.getPassword());
        user.setRole(userRegisterRequest.getRole());
    }

    public static UserRegisterResponse map(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setMessage("Registered Successfully");
        user.setEmail(user.getEmail());
        return userRegisterResponse;
    }

    public static UserLoginResponse mapLogin(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userLoginResponse.setMessage("Logged in Successfully");
        userLoginResponse.setLoggedIn(true);
        return userLoginResponse;
    }

    public static UserLoginResponse mapLogout(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userLoginResponse.setMessage("Logged out Successfully");
        userLoginResponse.setLoggedIn(false);
        return userLoginResponse;
    }

    public static void mapProduct(ProductRegisterRequest productRegisterRequest, Product product) {
        product.setProductName(productRegisterRequest.getProductName());
        product.setProductDescription(productRegisterRequest.getProductDescription());
        product.setProductPrice(productRegisterRequest.getProductPrice());
        product.setProductStock(productRegisterRequest.getProductStock());
        product.setProductCategory(productRegisterRequest.getProductCategory());
        }

    public static ProductRegisterResponse mapProduct(Product product) {
        ProductRegisterResponse productRegisterResponse = new ProductRegisterResponse();
        productRegisterResponse.setProductId(product.getProductId());
        productRegisterResponse.setMessage("Product Was Successfully Created");
        return productRegisterResponse;
    }

    public static void mapProductUpdate(ProductUpdatesRequest productUpdate, Product product) {
        product.setProductName(productUpdate.getProductName());
        product.setProductDescription(productUpdate.getProductDescription());
        product.setProductPrice(productUpdate.getProductPrice());
        product.setProductStock(productUpdate.getProductStock());
        product.setProductCategory(productUpdate.getProductCategory());
    }

    public static ProductUpdateResponse mapProductUpdate( Product product) {
        ProductUpdateResponse productResponse = new ProductUpdateResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setMessage("Product Was Successfully Updated");
        return productResponse;
    }

    public static void mapShoppingCart(ShoppingCartRegisterRequest shoppingCartRegisterRequest, ShoppingCart shoppingCart) {
        shoppingCart.setShoppingCart_id(shoppingCartRegisterRequest.getShoppingCart_id());
        shoppingCart.setCustomerName(shoppingCartRegisterRequest.getCustomerName());
        shoppingCart.setTotalPrice(shoppingCartRegisterRequest.getTotalPrice());
    }

    public static ShoppingCartRegisterResponse mapShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCartRegisterResponse shoppingCartRegisterResponse = new ShoppingCartRegisterResponse();
        shoppingCartRegisterResponse.setMessage("ShoppingCart Was Successfully Created");
        shoppingCartRegisterResponse.setShoppingCart_id(shoppingCart.getShoppingCart_id());
        return shoppingCartRegisterResponse;
    }

    public static void mapCartItem(ShoppingCartRegisterRequest shoppingCartRegisterRequest, CartItem cartItem) {
//        cartItem.setCartItem_id(shoppingCartRegisterRequest.getCartItems_id());
//        cartItem.setProductName(shoppingCartRegisterRequest.getProductName());
//        cartItem.setPrice(shoppingCartRegisterRequest.getPrice());
//        cartItem.setQuantityOfProducts(shoppingCartRegisterRequest.getQuantityOfProducts());
//        cartItem.setProductcategory(shoppingCartRegisterRequest.getProductcategory());
    }

    public static CartItemRegisterResponse mapCartItem(CartItem cartItem) {
        CartItemRegisterResponse cartItemRResponse = new CartItemRegisterResponse();
        cartItemRResponse.setMessage("CartItem Was Successfully Created");
        cartItemRResponse.setCartItem_id(cartItem.getCartItem_id());
        return cartItemRResponse;
    }


}