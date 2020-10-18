package com.example.rysowanie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;

public class SaveImageFromCanvasViewToGallery {
    public SaveImageFromCanvasViewToGallery(Activity activity, CanvasView canvasView)
    {
        canvasView.setDrawingCacheEnabled(true);
        canvasView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        String path = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        File file = new File(path+"/image.png");
        FileOutputStream ostream;
        try {
            file.createNewFile();
            ostream = new FileOutputStream(file);
            getBitmapFromView(canvasView).compress(Bitmap.CompressFormat.PNG, 100, ostream);
            ostream.flush();
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Bitmap getBitmapFromView(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

}
