package com.example.rysowanie;

import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;

public class SaveImageFromCanvasViewToGallery {
    public SaveImageFromCanvasViewToGallery(CanvasView canvasView)
    {
        canvasView.setDrawingCacheEnabled(true);
        canvasView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = canvasView.getDrawingCache();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(path+"/image.png");
        FileOutputStream ostream;
        try {
            file.createNewFile();
            ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
            ostream.flush();
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
