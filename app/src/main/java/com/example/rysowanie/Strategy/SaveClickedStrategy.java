package com.example.rysowanie.Strategy;

import android.app.Activity;
import android.app.AlertDialog;

import com.example.rysowanie.CanvasView;
import com.example.rysowanie.Listener.DialogConfirmClickListener;
import com.example.rysowanie.Listener.DialogDismissListener;
import com.example.rysowanie.R;

class SaveClickedStrategy
{
    SaveClickedStrategy(final Activity activity, final CanvasView view)
    {
        DialogDismissListener dismiss = new DialogDismissListener();

        new AlertDialog.Builder(view.getContext())
                .setMessage(R.string.confirm)
                .setPositiveButton(R.string.yes, new DialogConfirmClickListener(activity, view))
                .setNegativeButton(android.R.string.cancel, dismiss)
                .setOnCancelListener(dismiss)
                .create()
                .show();
    }

}
