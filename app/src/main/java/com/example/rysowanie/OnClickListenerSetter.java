package com.example.rysowanie;

import android.view.View;

public class OnClickListenerSetter
{
   public OnClickListenerSetter(View.OnClickListener listener, View... buttons) {
        for(View btn : buttons){
            btn.setOnClickListener(listener);
        }
    }
}
