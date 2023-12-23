package org.techtown.K_medicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageHorizontalLayout extends LinearLayout {

    public ImageHorizontalLayout(Context context, ImageSerializable imageSerializable) {
        super(context);
        init(context, imageSerializable);
    }

    private void init(Context context, ImageSerializable imageSerializable) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_image_horizontal_layout, this, true);

        ImageView glide_imageview = (ImageView)findViewById(R.id.glide_imageview);
        TextView tv_image_num = (TextView)findViewById(R.id.tv_image_num);

        // 이미지 로드 라이브러리 사용 ImageUrl to Image
        Glide.with(this)
                .load(imageSerializable.getImageUrl())
                .override(350,350)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(glide_imageview);
    }
}