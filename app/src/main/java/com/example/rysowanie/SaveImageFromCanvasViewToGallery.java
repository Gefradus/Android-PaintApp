package com.example.rysowanie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;

public class SaveImageFromCanvasViewToGallery
{
    public SaveImageFromCanvasViewToGallery(Activity activity, CanvasView canvasView)
    {
        File file = createFile(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());

        try {
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            getBitmapFromView(canvasView).compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            Toast.makeText(activity, "Twój obraz został zapisany pomyślnie", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private File createFile(String path)
    {
        int i = 0;
        File file = null;
        while(i == 0 || file.exists()) {
            i++;
            file = new File(path + "/image" + i + ".png");
        }
        return file;
    }

    private Bitmap getBitmapFromView(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

}
