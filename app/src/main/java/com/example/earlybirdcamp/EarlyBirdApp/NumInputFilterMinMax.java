package com.example.earlybirdcamp.EarlyBirdApp;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by earlybirdcamp on 6/15/16.
 */
public class NumInputFilterMinMax implements InputFilter {
    private int minNum, maxNum;

    public NumInputFilterMinMax(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
    }

    @Override
    public CharSequence filter(CharSequence source, int begin, int end, Spanned dest, int destBegin, int destEnd) {
        try {
            int uInput = Integer.parseInt(dest.toString() + source.toString());
            if (boolInRange(minNum, maxNum, uInput))
                return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean boolInRange(int num1, int num2, int num3) {
        return num2 > num1 ? num3 >= num1 && num3 <= num2 : num3 >= num2 && num3 <= num1;
    }
}
