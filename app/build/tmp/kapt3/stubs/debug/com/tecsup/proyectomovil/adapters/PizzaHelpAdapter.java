package com.tecsup.proyectomovil.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tecsup.proyectomovil.R;
import com.tecsup.proyectomovil.models.PizzaHelp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tecsup/proyectomovil/adapters/PizzaHelpAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tecsup/proyectomovil/adapters/PizzaHelpAdapter$PizzaViewHolder;", "pizzaList", "", "Lcom/tecsup/proyectomovil/models/PizzaHelp;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PizzaViewHolder", "app_debug"})
public final class PizzaHelpAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tecsup.proyectomovil.adapters.PizzaHelpAdapter.PizzaViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.tecsup.proyectomovil.models.PizzaHelp> pizzaList = null;
    
    public PizzaHelpAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.tecsup.proyectomovil.models.PizzaHelp> pizzaList) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.tecsup.proyectomovil.adapters.PizzaHelpAdapter.PizzaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tecsup.proyectomovil.adapters.PizzaHelpAdapter.PizzaViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tecsup/proyectomovil/adapters/PizzaHelpAdapter$PizzaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgPizza", "Landroid/widget/ImageView;", "textPizzaSubtitle", "Landroid/widget/TextView;", "textPizzaTitle", "bind", "", "pizza", "Lcom/tecsup/proyectomovil/models/PizzaHelp;", "app_debug"})
    public static final class PizzaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView imgPizza = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView textPizzaTitle = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView textPizzaSubtitle = null;
        
        public PizzaViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.tecsup.proyectomovil.models.PizzaHelp pizza) {
        }
    }
}