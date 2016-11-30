package utils.sq.org.fastblurbitmaputil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.sq.fastblur.FastBlur;
import org.sq.fastblur.FastBlurUtils;
import org.sq.utils.LogUtils;

public class MainActivity extends Activity {
    public static final String TAG = "MainActivity";

    ImageView fastBlurImageView, fastBlurImageView1, fastBlurImageView2, fastBlurImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fastBlurImageView = (ImageView) findViewById(R.id.fastblur_ImageView);

        fastBlurImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                long startTime = SystemClock.currentThreadTimeMillis();
                Bitmap blurBitmap = FastBlur.blurJava(originBitmap, 25, false);
                long endTime = SystemClock.currentThreadTimeMillis();
                LogUtils.d(TAG, "time " + (endTime - startTime));

                fastBlurImageView.setImageBitmap(blurBitmap);
            }
        });

        fastBlurImageView1 = (ImageView) findViewById(R.id.fastblur_ImageView1);
        fastBlurImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                long startTime = SystemClock.currentThreadTimeMillis();
                Bitmap blurBitmap = FastBlur.blurNatively(originBitmap, 25, false);
                long endTime = SystemClock.currentThreadTimeMillis();
                LogUtils.d(TAG, "time " + (endTime - startTime));

                fastBlurImageView1.setImageBitmap(blurBitmap);
            }
        });

        fastBlurImageView2 = (ImageView) findViewById(R.id.fastblur_ImageView2);
        fastBlurImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                long startTime = SystemClock.currentThreadTimeMillis();
                Bitmap blurBitmap = FastBlur.blurNativelyPixels(originBitmap, 25, false);
                long endTime = SystemClock.currentThreadTimeMillis();
                LogUtils.d(TAG, "time " + (endTime - startTime));

                fastBlurImageView2.setImageBitmap(blurBitmap);
            }
        });

        fastBlurImageView3 = (ImageView) findViewById(R.id.fastblur_ImageView3);
        fastBlurImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap originBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

                long startTime = SystemClock.currentThreadTimeMillis();
                Bitmap blurBitmap = FastBlur.blurRenderScript(MainActivity.this, originBitmap, 25, false);
                long endTime = SystemClock.currentThreadTimeMillis();
                LogUtils.d(TAG, "time " + (endTime - startTime));

                fastBlurImageView3.setImageBitmap(blurBitmap);
            }
        });

    }
}
