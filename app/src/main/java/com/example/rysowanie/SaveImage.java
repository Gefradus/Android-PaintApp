package com.example.rysowanie;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class SaveImage
{
    public SaveImage(Activity activity, CanvasView canvasView)
    {
        File file = createFile(activity);

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

    private Bitmap getBitmapFromView(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private File createFile(Activity activity)
    {
        int i = 0;
        File file = null;
        while(i == 0 || file.exists()) {
            file = new File(Objects.requireNonNull(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)).getAbsolutePath() + "/image" + ++i + ".png");
        }
        return file;
    }
}
