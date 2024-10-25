package com.tecsup.proyectomovil.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tecsup/proyectomovil/adapters/CartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tecsup/proyectomovil/adapters/CartAdapter$CartViewHolder;", "context", "Landroid/content/Context;", "pizzaList", "", "Lcom/tecsup/proyectomovil/Pizza;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CartViewHolder", "app_debug"})
public final class CartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.tecsup.proyectomovil.adapters.CartAdapter.CartViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.tecsup.proyectomovil.Pizza> pizzaList = null;
    
    public CartAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.tecsup.proyectomovil.Pizza> pizzaList) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.tecsup.proyectomovil.adapters.CartAdapter.CartViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.tecsup.proyectomovil.adapters.CartAdapter.CartViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tecsup/proyectomovil/adapters/CartAdapter$CartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tecsup/proyectomovil/adapters/CartAdapter;Landroid/view/View;)V", "decreaseButton", "Landroid/widget/Button;", "getDecreaseButton", "()Landroid/widget/Button;", "increaseButton", "getIncreaseButton", "pizzaImage", "Landroid/widget/ImageView;", "getPizzaImage", "()Landroid/widget/ImageView;", "pizzaName", "Landroid/widget/TextView;", "getPizzaName", "()Landroid/widget/TextView;", "pizzaPrice", "getPizzaPrice", "pizzaQuantity", "getPizzaQuantity", "app_debug"})
    public final class CartViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView pizzaImage = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView pizzaName = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView pizzaPrice = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView pizzaQuantity = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.Button increaseButton = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.Button decreaseButton = null;
        
        public CartViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getPizzaImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPizzaName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPizzaPrice() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPizzaQuantity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.Button getIncreaseButton() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.Button getDecreaseButton() {
            return null;
        }
    }
}