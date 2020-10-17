package com.example.rysowanie;

import android.view.View;

class OnClickListenerSetter
{
    OnClickListenerSetter(View.OnClickListener listener, View... buttons) {
        for(View btn : buttons){
            btn.setOnClickListener(listener);
        }
    }
}
