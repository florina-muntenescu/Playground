package fmuntenescu.playground.animations;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fmuntenescu.playground.R;

/**
 * Class that allows animation of a view component.
 */
public abstract class TapToSlideView extends RelativeLayout implements ISlidingView {

    private enum ViewType {ABOVE, BELOW, NONE}

    @Nullable
    private View mViewBelow;

    @Nullable
    private View mViewAbove;

    @Nullable
    private TextView mAnimationTypeView;

    @Nullable
    private TextView mViewTapped;

    private boolean mViewAboveAnimated;

    public TapToSlideView(final Context context) {
        super(context);
        init(context);
    }

    public TapToSlideView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(@NonNull final Context context) {
        View.inflate(context, R.layout.tap_animate_view, this);

        mViewAbove = findViewById(R.id.view_above);
        mViewBelow = findViewById(R.id.view_below);
        mAnimationTypeView = (TextView) findViewById(R.id.view_type);
        mViewTapped = (TextView) findViewById(R.id.view_tapped);

        setClickListeners();

        assert mAnimationTypeView != null;
        mAnimationTypeView.setText(getAnimationType());
    }

    private void setClickListeners() {
        assert mViewAbove != null;
        assert mViewBelow != null;
        assert mViewTapped != null;

        mViewAbove.setOnClickListener(v -> handleViewAboveClick());
        mViewBelow.setOnClickListener(v -> handleViewBelowClick());

        setOnClickListener(v -> viewTapped(ViewType.NONE));
    }

    private void handleViewAboveClick() {
        assert mViewAbove != null;

        viewTapped(ViewType.ABOVE);
        if (!mViewAboveAnimated) {
            mViewAboveAnimated = true;
            slideUp(mViewAbove);
        }
    }

    private void handleViewBelowClick() {
        assert mViewAbove != null;

        viewTapped(ViewType.BELOW);
        if (mViewAboveAnimated) {
            mViewAboveAnimated = false;
            slideDown(mViewAbove);
        }
    }

    private void viewTapped(@NonNull final ViewType viewType) {
        assert mViewTapped != null;

        switch (viewType) {
            case ABOVE:
                mViewTapped.setText(R.string.tap_above);
                break;
            case BELOW:
                mViewTapped.setText(R.string.tap_below);
                break;
            case NONE:
            default:
                mViewTapped.setText(R.string.tap_none);
                break;
        }
    }

}
