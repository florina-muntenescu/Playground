package fmuntenescu.playground.animations;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Interface for all views that can slide up and down.
 */
public interface ISlidingView {

    float TRANSLATION_FACTOR = 0.75f;

    /**
     * Slide a view up.
     */
    void slideUp(@NonNull View view);

    /**
     * Slide a view down.
     */
    void slideDown(@NonNull View view);

    /**
     * @return type of the animation used in order to perform the sliding up and down
     */
    @NonNull
    String getAnimationType();
}
