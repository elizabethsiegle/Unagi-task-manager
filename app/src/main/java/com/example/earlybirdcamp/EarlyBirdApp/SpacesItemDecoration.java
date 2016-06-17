package com.example.earlybirdcamp.EarlyBirdApp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Code from https://gist.github.com/nesquena/db922669798eba3e3661#file-spacesitemdecoration-java-L15
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int mSpace;
    public SpacesItemDecoration(int space) {
        this.mSpace = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace-5;
        outRect.right = mSpace-5;
        outRect.bottom = mSpace;
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = mSpace;
    }
}