package com.example.trabalhandocomimagens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgBtnShort, imgBtnMedium, imgBtnLarge;
    private Switch swtVertical, swtBackground;
    private ImageView imgTeste;
    private Spinner spnScaleType;
    private Button btnApply;
    private View dividerImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgBtnShort = findViewById(R.id.imgBtnShort);
        imgBtnMedium = findViewById(R.id.imgBtnMedium);
        imgBtnLarge = findViewById(R.id.imgBtnLarge);
        swtVertical = findViewById(R.id.swtVertical);
        swtBackground = findViewById(R.id.swtBackground);
        imgTeste = findViewById(R.id.imgTeste);
        spnScaleType = findViewById(R.id.spinnerScaleType);
        btnApply = findViewById(R.id.btnApply);
        dividerImg = findViewById(R.id.dividerImg);
    }

    public void imgBtnOnClick(View view){
        if (view.getId() == R.id.imgBtnShort){
            if (swtVertical.isChecked())
                imgTeste.setImageResource(R.drawable.imgv150x300);
            else
                imgTeste.setImageResource(R.drawable.img300x150);
        }
        if (view.getId() == R.id.imgBtnMedium) {
            if (swtVertical.isChecked())
                imgTeste.setImageResource(R.drawable.imgv300x600);
            else
                imgTeste.setImageResource(R.drawable.img600x300);
        }
        if (view.getId() == R.id.imgBtnLarge){
            if (swtVertical.isChecked())
                imgTeste.setImageResource(R.drawable.imgv600x1200);
            else
                imgTeste.setImageResource(R.drawable.img1200x600);
        }
    }

    public void swtBackgrounOnClick(View view){
        if (swtBackground.isChecked())
            dividerImg.setVisibility(View.VISIBLE);
        else
            dividerImg.setVisibility(View.INVISIBLE);
    }

    public void btnApplyOnClick(View view){
        switch (spnScaleType.getSelectedItemPosition()){
            case 0:
                imgTeste.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case 1:
                imgTeste.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case 2:
                imgTeste.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case 3:
                imgTeste.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case 4:
                imgTeste.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case 5:
                imgTeste.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case 6:
                imgTeste.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
        }
    }
}