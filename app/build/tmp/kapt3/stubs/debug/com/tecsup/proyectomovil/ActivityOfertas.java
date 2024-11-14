package com.tecsup.proyectomovil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tecsup.proyectomovil.models.Product;
import com.tecsup.proyectomovil.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tecsup/proyectomovil/ActivityOfertas;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "productAdapter", "Lcom/tecsup/proyectomovil/ActivityOfertas$ProductAdapter;", "productList", "", "Lcom/tecsup/proyectomovil/models/Product;", "recyclerViewOffers", "Landroidx/recyclerview/widget/RecyclerView;", "fetchProductsFromApi", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setupBottomNavigation", "setupRecyclerView", "setupToolbar", "ProductAdapter", "app_debug"})
public final class ActivityOfertas extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerViewOffers;
    private com.tecsup.proyectomovil.ActivityOfertas.ProductAdapter productAdapter;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.tecsup.proyectomovil.models.Product> productList = null;
    
    public ActivityOfertas() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fetchProductsFromApi() {
    }
    
    private final void setupBottomNavigation() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView() {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tecsup/proyectomovil/ActivityOfertas$ProductAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tecsup/proyectomovil/ActivityOfertas$ProductAdapter$ProductViewHolder;", "productList", "", "Lcom/tecsup/proyectomovil/models/Product;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ProductViewHolder", "app_debug"})
    public static final class ProductAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tecsup.proyectomovil.ActivityOfertas.ProductAdapter.ProductViewHolder> {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.tecsup.proyectomovil.models.Product> productList = null;
        
        public ProductAdapter(@org.jetbrains.annotations.NotNull
        java.util.List<com.tecsup.proyectomovil.models.Product> productList) {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.tecsup.proyectomovil.ActivityOfertas.ProductAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.tecsup.proyectomovil.ActivityOfertas.ProductAdapter.ProductViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tecsup/proyectomovil/ActivityOfertas$ProductAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "productImage", "Landroid/widget/ImageView;", "getProductImage", "()Landroid/widget/ImageView;", "productName", "Landroid/widget/TextView;", "getProductName", "()Landroid/widget/TextView;", "productPrice", "getProductPrice", "app_debug"})
        public static final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView productName = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView productPrice = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.ImageView productImage = null;
            
            public ProductViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View itemView) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getProductName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getProductPrice() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.ImageView getProductImage() {
                return null;
            }
        }
    }
}