package fmuntenescu.playground.animations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * View that contains a component that animates using XML animations.
 */
public class TapToSlideViewAnimationCodeView extends TapToSlideView {

    public TapToSlideViewAnimationCodeView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void slideUp(@NonNull final View view) {
        int toYDelta = (int) (view.getHeight() * (-TRANSLATION_FACTOR));
        animateView(view, toYDelta);
    }

    @Override
    public void slideDown(@NonNull final View view) {
        int toYDelta = (int) (view.getHeight() * TRANSLATION_FACTOR);
        animateView(view, toYDelta);
    }

    private void animateView(@NonNull final View view,
                             final int toYDelta) {
        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, toYDelta);
        animation.setFillAfter(true);
        animation.setDuration(getResources().getInteger(android.R.integer.config_longAnimTime));
        view.startAnimation(animation);
    }

    @Override
    public String getAnimationType() {
        return "ViewAnimation - code";
    }
}
