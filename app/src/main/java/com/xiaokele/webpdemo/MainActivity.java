package com.xiaokele.webpdemo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView ivStatic;
    private SimpleDraweeView ivMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button staticLoadBtn = (Button) findViewById(R.id.btn_load_static);
        Button moveLoadBtn = (Button) findViewById(R.id.btn_load_move);
        Button moveLoadBtn1 = (Button) findViewById(R.id.btn_load_move1);

        staticLoadBtn.setOnClickListener(this);
        moveLoadBtn.setOnClickListener(this);
        moveLoadBtn1.setOnClickListener(this);
        ivStatic = (SimpleDraweeView) findViewById(R.id.iv_static_simpleDraweeView);
        ivMove = (SimpleDraweeView) findViewById(R.id.iv_move_simpleDraweeView);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_load_static:
                ivStatic.setImageResource(R.drawable.bg_tool_image);
                break;
            case R.id.btn_load_move:
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse("res://" + getApplication().getPackageName() + "/" + R.drawable.show_webp))
                        .setControllerListener(controllerListener)
                        .build();
                ivMove.setController(build);
                break;
            case R.id.btn_load_move1:
                AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse("res://" + getApplication().getPackageName() + "/" + R.drawable.youlun))
                        .setControllerListener(controllerListener1)
                        .build();
                ivMove.setController(build1);
                break;
            default:
                break;
        }
    }

    ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
        @Override
        public void onFinalImageSet(
                String id,
                @Nullable ImageInfo imageInfo,
                @Nullable Animatable anim) {
            if (anim != null) {
                // app-specific logic to enable animation starting
                anim.start();
            }
        }
    };

    ControllerListener controllerListener1 = new BaseControllerListener<ImageInfo>() {
        @Override
        public void onFinalImageSet(
                String id,
                @Nullable ImageInfo imageInfo,
                @Nullable Animatable anim) {
            if (anim != null) {
                // app-specific logic to enable animation starting
                anim.start();
            }
        }
    };
}
