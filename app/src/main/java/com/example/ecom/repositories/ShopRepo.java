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
        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "drawable/imac", "The 21.5-inch iMac features a vibrant LED-backlit display with a resolution of 1920x1080 and a powerful 2.3GHz dual-core Intel Core i5 processor. With 8GB of DDR4 memory and a 1TB hard drive, it provides a balance of performance and storage. The Intel Iris Plus Graphics 640 ensures excellent graphics support."));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Air", 799, true, "drawable/ipad_air","The iPad Air, positioned between the standard iPad and iPad Pro, boasts a sleek design with a 10.9-inch Retina display. Powered by custom processors, it offers storage options starting from 64GB, front and rear cameras, Apple Pencil support, and biometric authentication via Touch ID or Face ID. Connectivity includes Wi-Fi/cellular models and a USB-C port. Running on the latest iPadOS, it ensures extended battery life, providing a versatile and powerful tablet experience. Check Apple's official website for model-specific details."));
        productList.add(new Product(UUID.randomUUID().toString(), "iPad Pro", 999, true, "drawable/ipad_pro","The iPad Pro, a premium tablet by Apple, boasts a sleek design, Liquid Retina display, and powerful custom processors. Available in 11-inch and 12.9-inch sizes, it features advanced cameras, supports Apple Pencil and Magic Keyboard, and offers biometric authentication. With various storage options, USB-C connectivity, and running on the latest iPadOS, it delivers high performance and extended battery life. Some models include 5G support for faster connectivity. Check Apple's official website for model-specific details."));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11", 699, false, "drawable/iphone11","The iPhone 11, released in September 2019, features a sleek glass design, a 6.1-inch Liquid Retina HD display, and the A13 Bionic chip. With storage options up to 256GB, it boasts a dual-camera system with Night mode, Face ID authentication, and all-day battery life. Water-resistant (IP68) and supporting wireless charging, it runs on iOS and offers spatial audio with Dolby Atmos. For the latest details, check the official Apple website."));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone SE", 599, true, "drawable/iphone_se","The iPhone SE, powered by the A13 Bionic chip, features a compact design with a 4.7-inch Retina HD display and a single 12MP camera. Offering a budget-friendly option with Touch ID, it supports wireless charging and fast charging, running on the latest iOS versions. Visit the official Apple website for more details."));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 14", 799, true, "drawable/iphone","The iPhone 14 boasts a 6.06-inch display, Apple A15 Bionic processor, and storage options of 128GB, 256GB, or 512GB. It features advanced camera capabilities, including a 12MP front camera, 12MP + 12MP rear cameras, and a new 12MP main camera with improved low-light performance. With a sleek design, extraordinary battery life, and iOS 16, it introduces satellite connectivity for emergency SOS and prioritizes sustainability with recycled materials."));
        mutableProductList.setValue(productList);
    }
}