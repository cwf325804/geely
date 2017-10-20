package com.geely;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * git test
 * Created by wenfu.chen on 2017/10/20.
 */

public class HelloActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);
    }
}
