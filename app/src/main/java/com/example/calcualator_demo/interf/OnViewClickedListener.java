package com.example.calcualator_demo.interf;

public interface OnViewClickedListener {
    void addToExpression(char textExpressions);

    void calculate();

    void clearAll();

    void clearExpression();
}