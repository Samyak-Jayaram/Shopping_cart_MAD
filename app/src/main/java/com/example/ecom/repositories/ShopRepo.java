package com.example.ecom.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ecom.R;
import com.example.ecom.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {

        String imageUri = "C:\\Users\\DELL\\Desktop\\java apps\\ECom\\app\\src\\main\\res\\drawable";
        String[] imageId = {
                imageUri + R.drawable.imac,
        };
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "drawable/imac"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Air", 799, true, "drawable/ipad_air"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Pro", 999, true, "drawable/ipad_pro"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11", 699, false, "drawable/iphone11"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone SE", 599, true, "drawable/iphone_se"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone", 799, true, "drawable/iphone"));
        mutableProductList.setValue(productList);
    }
}