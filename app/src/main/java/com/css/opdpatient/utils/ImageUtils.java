package com.css.opdpatient.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

/***
 * Project created by Jyoti on 19 Jan 2018 Friday
 * ImageUtils will load user image from url
 */
public class ImageUtils {

    static String TAG = "ImageUtils";

    /***
     * will set user image
     * @param context
     * @param imageUrl
     * @param targetImageView
     */
    public static void setImage(Context context, final String imageUrl, ImageView targetImageView) {
        if (imageUrl != null) {
            Picasso.with(context)
                    .load(imageUrl)
                    //.placeholder(R.drawable.default_user)
                    .into(targetImageView, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d(TAG, "loadImagePicasso :: onSuccess :: " + imageUrl);
                        }

                        @Override
                        public void onError() {
                            Log.d(TAG, "loadImagePicasso :: onError :: " + imageUrl);
                        }
                    });
        } else {
            // targetImageView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.default_user));
        }
    }   //end of setImage


    public static String encodeToBase64(Bitmap image) {
        String imageEncoded = null;
        try {
            Bitmap immagex = image;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            immagex.compress(Bitmap.CompressFormat.PNG, 10, baos);
            byte[] b = baos.toByteArray();
            imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        } catch (Exception e) {
            Log.d("ImageUtils", "error while converting to code");
        }
        return imageEncoded;
    }//end of encodeToBase64()
}   //end of ImageUtils
