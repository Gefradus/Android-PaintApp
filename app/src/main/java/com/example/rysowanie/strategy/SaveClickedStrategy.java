package com.example.rysowanie.strategy;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.SeekBar;
import com.example.rysowanie.CanvasView;
import com.example.rysowanie.listener.DialogConfirmClickListener;
import com.example.rysowanie.listener.DialogDismissListener;
import com.example.rysowanie.R;

public class SaveClickedStrategy implements IButtonClickedStrategy
{
    @Override
    public void onClickAction(CanvasView view, SeekBar seekBar, Activity activity) {
        DialogDismissListener dismiss = new DialogDismissListener();

        new AlertDialog.Builder(view.getContext())
                .setMessage(R.string.confirm)
                .setPositiveButton(R.string.save, new DialogConfirmClickListener(activity, view))
                .setNegativeButton(R.string.cancel, dismiss)
                .setOnCancelListener(dismiss)
                .create()
                .show();
    }
}
