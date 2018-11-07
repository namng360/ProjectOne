package vn.edu.poly.projectone.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import vn.edu.poly.projectone.R;

public class IntroActivity extends AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        }

        changeStatusBarColor();


        addSlide(AppIntroFragment.newInstance(getString(R.string.food), getString(R.string.food_hint), R.drawable.food_ic, ContextCompat.getColor(getApplicationContext(), R.color.light_red)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.northern), getString(R.string.northern_hint), R.drawable.mienbac, ContextCompat.getColor(getApplicationContext(), R.color.light_purple)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.south), getString(R.string.south_hint), R.drawable.miennam, ContextCompat.getColor(getApplicationContext(), R.color.light_orange)));
        addSlide(AppIntroFragment.newInstance(getString(R.string.central), getString(R.string.central_hint), R.drawable.mientrung, ContextCompat.getColor(getApplicationContext(), R.color.light_cyan)));

        showSkipButton(true);
        setProgressButtonEnabled(true);

        setVibrate(true);
        setVibrateIntensity(30);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(IntroActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(IntroActivity.this, MenuActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}
