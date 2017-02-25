package me.hasan.miuportal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Developer extends AppCompatActivity {

    private ImageView devImage;
    private RoundImage roundImage;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        devImage = (ImageView) findViewById(R.id.devImage);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dev);
        roundImage = new RoundImage(bitmap);
        devImage.setImageDrawable(roundImage);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
