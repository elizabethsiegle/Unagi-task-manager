package com.example.earlybirdcamp.EarlyBirdApp;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by earlybirdcamp on 6/15/16.
 */

public class TextInputFilterMaxNumDays implements InputFilter {
    private int maxNumDays;
    private int minNumDays;

    public TextInputFilterMaxNumDays(int minNumDays, int maxNumDays) {
        this.minNumDays = minNumDays;
        this.maxNumDays = maxNumDays;
    }

    @Override
    public CharSequence filter(CharSequence source, int beginDay, int endDay, Spanned destination, int destBegin, int destEnd) {
        try {
            int uInput = Integer.parseInt(destination.toString() + source.toString());
            if (boolInRange(minNumDays, maxNumDays, uInput))
                return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }
//            //remove string out of destination that is to be replaced
//            String newVal = destination.toString().substring(0, destBegin) + destination.toString().substring(destEnd, destination.toString().length());
//
//            //add new str in
//            newVal = newVal.substring(0, destBegin) + source.toString() + newVal.substring(destBegin, newVal.length());
//            int uInput = Integer.parseInt(newVal);
//            if (boolInRange(minNumDays, maxNumDays, uInput))
//                return null;
//        } catch(NumberFormatException nfe) { }
//            return "";
//        }


    private boolean boolInRange(int num1, int num2, int num3) {
        return num2 > num1 ? num3 >= num1 && num3 <= num2 : num3 >= num2 && num3 <= num1;
    } //private bool
}
