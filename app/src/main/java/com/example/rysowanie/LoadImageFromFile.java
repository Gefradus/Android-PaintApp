package com.example.rysowanie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.DisplayMetrics;

public class LoadImageFromFile {
    public LoadImageFromFile(Activity activity, CanvasView canvasView, String imageName) {
        Bitmap bitmap = createBitmapFromFile(activity, imageName);
        canvasView.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    private Bitmap createBitmapFromFile(Activity activity, String imageName)
    {
        Bitmap bitmap = BitmapFactory.decodeFile(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + imageName, new BitmapFactory.Options());
        bitmap = Bitmap.createScaledBitmap(bitmap, getCanvasWidth(activity), getCanvasHeight(activity), true);
        return bitmap;
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
