package com.example.rysowanie;

import android.app.Activity;
import android.app.AlertDialog;
import com.example.rysowanie.Listener.DialogConfirmClickListener;
import com.example.rysowanie.Listener.DialogDismissListener;

public class ConfirmSaveDialog
{
    public ConfirmSaveDialog(final Activity activity, final CanvasView view)
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
