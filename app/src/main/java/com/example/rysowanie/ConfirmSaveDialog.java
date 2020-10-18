package com.example.rysowanie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class ConfirmSaveDialog
{
    public ConfirmSaveDialog(final Activity activity, final CanvasView view)
    {
        new AlertDialog.Builder(view.getContext()).setMessage(R.string.confirm)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new SaveImageFromCanvasViewToGallery(activity, view);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

}
