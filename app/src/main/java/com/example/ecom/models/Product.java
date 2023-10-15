package com.example.ecom.models;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

public class Product {
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

    private String description;

    public Product(String id, String name, double price, boolean isAvailable, String imageUrl , String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
        this.description =description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description =description;}


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                " , description='" +description + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                isAvailable() == product.isAvailable() &&
                getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getDescription().equals(product.getDescription()) &&
                getImageUrl().equals(product.getImageUrl());
    }

    public static DiffUtil.ItemCallback<Product> itemCallback = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Context context = imageView.getContext();

        // Check if imageUrl is a resource name (without the "drawable/" prefix)
        if (imageUrl != null && imageUrl.startsWith("drawable/")) {
            int resourceId = context.getResources().getIdentifier(
                    imageUrl.substring("drawable/".length()), "drawable", context.getPackageName());

            if (resourceId != 0) {
                Glide.with(imageView)
                        .load(resourceId)
                        .fitCenter()
                        .into(imageView);
            }
        } else {
            Glide.with(imageView)
                    .load(imageUrl)
                    .fitCenter()
                    .into(imageView);
        }
    }
}