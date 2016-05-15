package fmuntenescu.playground.animations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

/**
 * View that contains a component that animates using XML animations.
 */
public class TapToSlidePropertyAnimationProgrammaticView extends TapToSlideView {

    public TapToSlidePropertyAnimationProgrammaticView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void slideUp(@NonNull final View view) {
        float animateByPx = view.getHeight() * (-TRANSLATION_FACTOR);
        translateViewYByPx(view, animateByPx);
    }

    @Override
    public void slideDown(@NonNull final View view) {
        float animateByPx = view.getHeight() * TRANSLATION_FACTOR;
        translateViewYByPx(view, animateByPx);
    }

    private void translateViewYByPx(@NonNull final View view,
                                    final float animateByPx) {
        view.animate().translationYBy(animateByPx);
    }

    @Override
    public String getAnimationType() {
        return "Property Animation - programmatic";
    }
}
