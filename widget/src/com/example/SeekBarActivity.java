package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-5
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public class SeekBarActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.seek_bar);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seek);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setTitle("seekBar,i="+i+",b="+b);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

    }
}
