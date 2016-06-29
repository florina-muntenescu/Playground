package fmuntenescu.playground.vectordrawables;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * ImageView that measures the time took to draw.
 */
public class MeasurableImageView extends ImageView {

    @Nullable
    private DrawListener mDrawListener;

    public MeasurableImageView(final Context context) {
        super(context);
    }

    public MeasurableImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasurableImageView(final Context context, final AttributeSet attrs,
                               final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDrawListener(@NonNull final DrawListener drawListener) {
        assert drawListener != null;

        mDrawListener = drawListener;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        long startTime = System.currentTimeMillis();

        super.onDraw(canvas);

        long endTime = System.currentTimeMillis();
        notifyDraw(startTime, endTime);
    }

    @Override
    public void invalidate() {
        Log.d("flo", "invalidate");
        super.invalidate();
    }

    private void notifyDraw(final long startTime, final long endTime) {
        long duration = endTime - startTime;

        Log.d("flo", "draw took " + duration);

        if (mDrawListener != null) {
            mDrawListener.viewDrawn(duration);
        }
    }
}
