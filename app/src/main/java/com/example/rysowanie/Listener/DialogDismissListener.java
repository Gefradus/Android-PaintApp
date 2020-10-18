package com.example.rysowanie.Listener;

import android.content.DialogInterface;

public class DialogDismissListener implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener
{
    @Override
    public void onClick(DialogInterface dialog, int i) {
        dialog.dismiss();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dialog.dismiss();
    }
}
