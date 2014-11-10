package com.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-7
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */
public class ImageSwitchGalleryActivity extends Activity {
    private ImageSwitcher imageSwitcher;
    private Gallery gallery;
    private static int[] images = {R.drawable.gugong,R.drawable.men1,R.drawable.men2,
            R.drawable.square,R.drawable.tan1,R.drawable.men2,R.drawable.wall1,
            R.drawable.wall2,R.drawable.wall3,R.drawable.west_station
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Android里用来隐藏标题栏的函数，用在Android4.0以上的手机时，运行良好，
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.image_switch_gallery);
        setTitle("切换图片");

        imageSwitcher = (ImageSwitcher)findViewById(R.id.switcher);
        imageSwitcher.setFactory(new ImageFactory(this));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        gallery = (Gallery)findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        //让选定的图片再中心显示
        gallery.setSelection(images.length/2);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //当在Gallery中选定一张图片时，ImageView同步显示同一张
//                position%images.length是为了图片循环显示
                imageSwitcher.setImageResource( images[position%images.length] );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }


    private class ImageAdapter extends BaseAdapter{
        private Context context;

        private ImageAdapter(Context context) {
            this.context = context;
        }

        //也可以return image.length(),在这里返回Integer.MAX_VALUE;是为了使图片循环显示
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object getItem(int position) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public long getItemId(int position) {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource( images[ position%images.length ] );
            imageView.setLayoutParams(new Gallery.LayoutParams(200,200));
            imageView.setAdjustViewBounds(true);
            return imageView;
        }
    }
    private class ImageFactory implements ViewSwitcher.ViewFactory{
        private Context context;

        private ImageFactory(Context context) {
            this.context = context;
        }

        @Override
        public View makeView() {
            ImageView i = new ImageView(context);
            i.setBackgroundColor(0xFF000000);
            i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            i.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            return i;
        }
    }


}
