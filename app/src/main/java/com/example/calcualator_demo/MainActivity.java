package com.example.calcualator_demo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.calcualator_demo.constant.Constant;
import com.example.calcualator_demo.fragment.ModeFragment;
import com.example.calcualator_demo.interf.OnViewClickedListener;
import com.example.calcualator_demo.utils.Calculator;
import com.example.calcualator_demo.utils.ShowToast;

public class MainActivity extends AppCompatActivity implements OnViewClickedListener {

    private SharedPreferences mSharedPreferences;
    private TextView mTextViewExpression, mTextViewResult;
    private StringBuilder mExpression;
    private float mResult;
    private TextView tvMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences = getSharedPreferences(Constant.PREF_KEY, MODE_PRIVATE);
        mResult = mSharedPreferences.getFloat(Constant.PREF_RESULT, 0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ModeFragment modeFragment = new ModeFragment();
        transaction.add(R.id.fragment, modeFragment);
        transaction.commit();
        init();
        addListener();

    }

    private void addListener() {
        tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, tvMenu);
                popupMenu.inflate(R.menu.menu_setting);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_save_result:
                                mSharedPreferences
                                        .edit()
                                        .putFloat(Constant.PREF_RESULT, mResult)
                                        .apply();
                                ShowToast.showToast(MainActivity.this, "lưu thanh công");
                                return true;
                            case R.id.menu_clean_result:
                                mSharedPreferences.edit().clear().apply();
                                ShowToast.showToast(MainActivity.this, "Xóa dữ liệu ");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    public void init() {
        mExpression = new StringBuilder();
        mTextViewExpression = findViewById(R.id.text_expression);
        mTextViewResult = findViewById(R.id.text_result);
        mTextViewResult.setText(String.valueOf(mResult));
        tvMenu = findViewById(R.id.tv_menu);
    }

    @Override
    public void addToExpression(char textToExpression) {
        mExpression.append(textToExpression);
        mTextViewExpression.setText(mExpression.toString());
    }


    @Override
    public void calculate() {
        if (!Calculator.checkSyntax(mExpression.toString())) {
            mTextViewResult.setText(getString(R.string.text_result_error));
            ShowToast.showToast(this,getString(R.string.message_expression_error));
        } else {
            mResult = Calculator.result(mExpression.toString());
            mTextViewResult.setText(String.valueOf(mResult));
            mTextViewExpression.setText(mExpression);
        }
    }

    @Override
    public void clearAll() {
        mTextViewResult.setText(R.string.number_zero);
        mExpression = new StringBuilder();
        mTextViewExpression.setText(mExpression);
    }

    @Override
    public void clearExpression() {
        mExpression = new StringBuilder();
        mTextViewExpression.setText(mExpression);
    }

}

