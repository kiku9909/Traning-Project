package com.example.traniningproject;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.Toast;


public class CameraDemo extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private static final int CAMERA_REQUEST = 1;
    private ImageView CaptureImg;
    private ScaleGestureDetector scaleGestureDetector;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CaptureImg = (ImageView) findViewById(R.id.captureImg);

        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
        } else {
            openCamera();
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else {
                Snackbar.make((CameraDemo.this).findViewById(R.id.cameraContext),getResources().getString(R.string.Permission_deined_msg),Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            Bitmap img = (Bitmap) data.getExtras().get("data");
            CaptureImg.setImageBitmap(img);
            Toast.makeText(CameraDemo.this,"camera working",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(CameraDemo.this,"camera Error",Toast.LENGTH_LONG).show();
        }
    }



    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        private Float ScaAFloat = 1f;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            ScaAFloat *= detector.getScaleFactor();
            ScaAFloat = Math.max(0.1f,Math.min(ScaAFloat,5.0f));
            Matrix matrix = new Matrix();
            matrix.setScale(ScaAFloat,ScaAFloat);
            CaptureImg.setImageMatrix(matrix);
            return true;
        }
    }
}
