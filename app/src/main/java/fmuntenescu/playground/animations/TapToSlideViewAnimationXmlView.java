package fmuntenescu.playground.animations;

import android.content.Context;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import fmuntenescu.playground.R;

/**
 * View that contains a component that animates using XML animations.
 */
public class TapToSlideViewAnimationXmlView extends TapToSlideView {

    public TapToSlideViewAnimationXmlView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void slideUp(@NonNull final View view) {
        animateView(view, R.anim.translate_up);
    }

    @Override
    public void slideDown(@NonNull final View view) {
        animateView(view, R.anim.translate_down);
    }

    private void animateView(@NonNull final View view,
                             @AnimRes final int animationId) {
        Animation animation = AnimationUtils.loadAnimation(getContext(), animationId);
        view.startAnimation(animation);
    }

    @Override
    public String getAnimationType() {
        return "ViewAnimation - XML";
    }
}
