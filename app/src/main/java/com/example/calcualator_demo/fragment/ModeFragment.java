package com.example.calcualator_demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.calcualator_demo.MainActivity;
import com.example.calcualator_demo.interf.OnViewClickedListener;
import com.example.calcualator_demo.R;
import com.example.calcualator_demo.constant.Constant;

public class ModeFragment extends Fragment implements View.OnClickListener {

    private OnViewClickedListener listener;
    private Button mOne, mTwo, mThree, mFour, mFive, mSix, mSeven, mEight, mNine, mZero;
    private Button mAdd, mSub, mMul, mDiv, mPlusMinus;
    private Button mAc, mPercent, mDot, mEqual;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity)
            this.listener = (OnViewClickedListener) context;
        else
            throw new RuntimeException(context.toString() + R.string.message_nullView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mode, container, false);
        init(view);
        addListener();
        return view;
    }

    private void addListener() {
        mZero.setOnClickListener(this);
        mOne.setOnClickListener(this);
        mTwo.setOnClickListener(this);
        mThree.setOnClickListener(this);
        mFour.setOnClickListener(this);
        mFive.setOnClickListener(this);
        mSix.setOnClickListener(this);
        mSeven.setOnClickListener(this);
        mEight.setOnClickListener(this);
        mNine.setOnClickListener(this);
        mAdd.setOnClickListener(this);
        mSub.setOnClickListener(this);
        mDiv.setOnClickListener(this);
        mMul.setOnClickListener(this);
        mPlusMinus.setOnClickListener(this);
        mAc.setOnClickListener(this);
        mPercent.setOnClickListener(this);
        mDot.setOnClickListener(this);
        mEqual.setOnClickListener(this);
    }

    private void init(View view) {
        mZero = (Button) view.findViewById(R.id.btn_number_zero);
        mOne = (Button) view.findViewById(R.id.btn_number_one);
        mTwo = (Button) view.findViewById(R.id.btn_number_two);
        mThree = (Button) view.findViewById(R.id.btn_number_three);
        mFour = (Button) view.findViewById(R.id.btn_number_four);
        mFive = (Button) view.findViewById(R.id.btn_number_five);
        mSix = (Button) view.findViewById(R.id.btn_number_six);
        mSeven = (Button) view.findViewById(R.id.btn_number_seven);
        mEight = (Button) view.findViewById(R.id.btn_number_eight);
        mNine = (Button) view.findViewById(R.id.btn_number_nine);
        mAdd = (Button) view.findViewById(R.id.btn_operator_add);
        mSub = (Button) view.findViewById(R.id.btn_operator_sub);
        mDiv = (Button) view.findViewById(R.id.btn_operator_div);
        mMul = (Button) view.findViewById(R.id.btn_operator_mul);
        mPlusMinus = (Button) view.findViewById(R.id.btn_operator_plus_minus);
        mAc = (Button) view.findViewById(R.id.btn_clear_all);
        mPercent = (Button) view.findViewById(R.id.btn_operator_perecent);
        mDot = (Button) view.findViewById(R.id.bnt_dot);
        mEqual = (Button) view.findViewById(R.id.btn_equal);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_number_zero:
                listener.addToExpression(Constant.ZERO);
                break;
            case R.id.btn_number_one:
                listener.addToExpression(Constant.ONE);
                break;
            case R.id.btn_number_two:
                listener.addToExpression(Constant.TWO);
                break;
            case R.id.btn_number_three:
                listener.addToExpression(Constant.THREE);
                break;
            case R.id.btn_number_four:
                listener.addToExpression(Constant.FOUR);
                break;
            case R.id.btn_number_five:
                listener.addToExpression(Constant.FIVE);
                break;
            case R.id.btn_number_six:
                listener.addToExpression(Constant.SIX);
                break;
            case R.id.btn_number_seven:
                listener.addToExpression(Constant.SEVEN);
                break;
            case R.id.btn_number_eight:
                listener.addToExpression(Constant.EIGHT);
                break;
            case R.id.btn_number_nine:
                listener.addToExpression(Constant.NINE);
                break;
            case R.id.bnt_dot:
                listener.addToExpression(Constant.DOT);
                break;
            case R.id.btn_operator_add:
                listener.addToExpression(Constant.ADD);
                break;
            case R.id.btn_operator_sub:
                listener.addToExpression(Constant.SUB);
                break;
            case R.id.btn_operator_mul:
                listener.addToExpression(Constant.MUL);
                break;
            case R.id.btn_operator_div:
                listener.addToExpression(Constant.DIV);
                break;
            case R.id.btn_operator_perecent:
                listener.addToExpression(Constant.PERCENT);
                break;
            case R.id.btn_operator_plus_minus:
                listener.addToExpression(Constant.PLUS_MINUS);
                break;
            case R.id.btn_clear_all:
                listener.clearAll();
                break;
            case R.id.btn_equal:
                listener.calculate();
                listener.clearExpression();
                break;
            default:
                break;
        }
    }

}
