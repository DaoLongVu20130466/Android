package com.project.android.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.UploadTask;
import com.project.android.R;
import com.project.android.controller.AccountControl;
import com.project.android.controller.PictureController;
import com.project.android.controller.ProductControl;
import com.project.android.model.Account;
import com.project.android.model.Product;

public class MainActivity extends AppCompatActivity {
    Button check ;
    Button openG;
    ImageView next;
    TextView text;
    PictureController pictureController;
    int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = findViewById(R.id.Imagebutton);
        openG = findViewById(R.id.opengalerry);
        next = findViewById(R.id.pictureView);
        text = findViewById(R.id.Path);
        openG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 2);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pictureController = new PictureController(next);
                pictureController.uploadFileFromCamera().addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Loi r",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(MainActivity.this,"Ok roi",Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this,taskSnapshot.getMetadata().getReference().getDownloadUrl().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== 1 &&resultCode ==RESULT_OK && data!=null){
            next.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
        else if (requestCode== 2 &&resultCode ==RESULT_OK && data!=null){
            Uri selectedImage = data.getData();
            text.setText(selectedImage.getPath());
            next.setImageURI(selectedImage);
        }
    }
}