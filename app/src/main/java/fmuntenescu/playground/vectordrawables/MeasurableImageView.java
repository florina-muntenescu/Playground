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
    private ViewRedrawnListener mViewRedrawnListener;

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

    public void setViewRedrawnListener(@NonNull final ViewRedrawnListener viewRedrawnListener) {
        assert viewRedrawnListener != null;

        mViewRedrawnListener = viewRedrawnListener;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        long startTime = System.currentTimeMillis();

        super.onDraw(canvas);

        long endTime = System.currentTimeMillis();
        notifyDraw(startTime, endTime);
    }

    private void notifyDraw(final long startTime, final long endTime) {
        long duration = endTime - startTime;

        Log.d("playground", "rendering took " + duration);

        if (mViewRedrawnListener != null) {
            mViewRedrawnListener.onRedraw(duration);
        }
    }
}
