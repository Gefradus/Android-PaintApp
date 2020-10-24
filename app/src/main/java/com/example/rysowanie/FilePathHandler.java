package com.example.rysowanie;

import android.app.Activity;
import android.os.Environment;

import java.io.File;

class FilePathHandler {
    static File createFile(Activity activity)
    {
        int i = 0;
        File file = null;
        while(i == 0 || file.exists()) {
            file = new File(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/image" + ++i + ".png");
        }
        return file;
    }
}
