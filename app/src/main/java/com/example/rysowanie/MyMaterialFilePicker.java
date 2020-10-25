package com.example.rysowanie;

import android.app.Activity;
import android.os.Environment;

import com.nbsp.materialfilepicker.MaterialFilePicker;

import java.util.regex.Pattern;

public class MyMaterialFilePicker extends MaterialFilePicker {
    public MyMaterialFilePicker(Activity activity){
                this.withActivity(activity)
                .withCloseMenu(true)
                .withFilter(Pattern.compile(".*\\.(jpg|jpeg|png)$"))
                .withFilterDirectories(false)
                .withRootPath(activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath())
                .withTitle("Wybierz obrazek")
                .withRequestCode(1000)
                .withHiddenFiles(true)
                .start();
    }
}
