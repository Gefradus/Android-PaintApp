package com.example.rysowanie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

import com.example.rysowanie.activity.MainActivity;

public class LoadImageFromFile {
    LoadImageFromFile(MainActivity activity, int imageId) {
        activity.getCanvasView().setBackgroundDrawable(new BitmapDrawable(createBitmapFromResourceFile(activity, imageId)));
    }

    LoadImageFromFile(MainActivity activity, String imagePath){
        activity.getCanvasView().setBackgroundDrawable(new BitmapDrawable(createBitmapFromMemoryFile(activity, imagePath)));
    }

    private Bitmap createBitmapFromResourceFile(Activity activity, int imageId) {
        return createScaledBitmap(activity, BitmapFactory.decodeResource(activity.getResources(), imageId));
    }

    private Bitmap createBitmapFromMemoryFile(Activity activity, String path) {
        return createScaledBitmap(activity, BitmapFactory.decodeFile(path));
    }

    private Bitmap createScaledBitmap(Activity activity, Bitmap bitmap){
        return Bitmap.createScaledBitmap(bitmap, getCanvasWidth(activity), getCanvasHeight(activity), true);
    }

    private int getCanvasWidth(Activity activity) {
        return getScreenMetrics(activity).widthPixels * 4 / 5;
    }

    private int getCanvasHeight(Activity activity){
        return getScreenMetrics(activity).heightPixels * 10 / 11;
    }

    private DisplayMetrics getScreenMetrics(Activity activity){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
