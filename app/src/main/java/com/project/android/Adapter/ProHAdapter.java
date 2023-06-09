package com.project.android.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.android.R;
import com.project.android.model.Product;

import java.util.List;

public class ProHAdapter extends RecyclerView.Adapter<ProHAdapter.ProView> {
    private Context context;
    private List<Product> myListpro ;

    public ProHAdapter(List<Product> productList) {
        this.myListpro = productList;
        notifyDataSetChanged();
    }

    public void setData(List<Product> pro2){
        this.myListpro = pro2;
        notifyDataSetChanged();


    }
    @NonNull
    @Override
    public ProView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pro_home,parent,false);
        return new ProView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProView holder, int position) {
        Product product = myListpro.get(position);
        if (product  == null) {
            return;
        }
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference photoReference= storageReference.child(product.getImg());

        final long ONE_MEGABYTE = 1024 * 1024;
        photoReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.imageView.setImageBitmap(bmp);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });
        holder.textView.setText(product.getFoodName());
        holder.textView2.setText(product.getIdType());
    }

    @Override
    public int getItemCount() {
        if (myListpro != null){
            return myListpro.size();
        }
        return 0;
    }

    public class ProView extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private TextView textView2;

        public ProView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_proh);
            textView = itemView.findViewById(R.id.name_proh);
            textView2 = itemView.findViewById(R.id.price_proh);
        }
    }
}
