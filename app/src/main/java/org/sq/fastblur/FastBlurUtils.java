package org.sq.fastblur;

import android.graphics.Bitmap;

/**
 * 高斯模糊JNI处理类
 * Created by jimmy on 2016/11/26.
 */

public final class FastBlurUtils {

    public static final String LIBRARY_NAME = "fast-blur";

    static {
        System.loadLibrary(LIBRARY_NAME);
    }

    /**
     * Blur Image By Pixels
     *
     * @param img    Img pixel array
     * @param width  Img width
     * @param height Img height
     * @param radius Blur radius
     */
    protected static native void blurPixels(int[] img, int width, int height, int radius);

    /**
     * Blur Image By Bitmap
     *
     * @param bitmap Img Bitmap
     * @param radius Blur radius
     */
    protected static native void blurBitmap(Bitmap bitmap, int radius);


}
