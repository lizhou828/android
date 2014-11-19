import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import com.example.MyImageView;
import com.example.R;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-11-19
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */
public class GalleryAdapter extends BaseAdapter {

    private Context context;
    private int images[] = { R.drawable.chrysanthemum, R.drawable.desert, R.drawable.hydrangeas, R.drawable.penguins};

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), images[position]);
        MyImageView view = new MyImageView(context, bmp.getWidth(), bmp.getHeight());
        view.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        view.setImageBitmap(bmp);
        return view;
    }

}

