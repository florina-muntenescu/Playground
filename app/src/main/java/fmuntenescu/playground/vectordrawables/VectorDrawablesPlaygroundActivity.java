package fmuntenescu.playground.vectordrawables;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import fmuntenescu.playground.R;

/**
 * Playground for Vector Drawables.
 */
public class VectorDrawablesPlaygroundActivity extends AppCompatActivity {

    @Nullable
    private TextView mDurationText;

    @Nullable
    private MeasurableImageView mMeasurableImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector_drawables_playground_activity);

        mDurationText = (TextView) findViewById(R.id.draw_duration_text);
        mMeasurableImageView = (MeasurableImageView) findViewById(
                R.id.measurable_image);

        assert mMeasurableImageView != null;
        mMeasurableImageView.setDrawListener(this::updateDuration);

        RadioGroup group = (RadioGroup) findViewById(R.id.drawable_choice);
        assert group != null;
        group.check(R.id.vector_drawable_button);
        group.setOnCheckedChangeListener((group1, checkedId) -> checkedChanged(checkedId));

    }

    private void updateDuration(final long miliseconds) {
        assert mDurationText != null;

        mDurationText.setText(getString(R.string.duration, miliseconds));
    }

    private void checkedChanged(@IdRes final int checkedId) {
        switch (checkedId) {
            case R.id.vector_drawable_button:
                vectorDrawableSelected();
                break;
            case R.id.png_button:
                pngSelected();
                break;
        }
    }

    private void vectorDrawableSelected() {
        assert mMeasurableImageView != null;
        mMeasurableImageView.setImageResource(R.drawable.placeholder);
    }

    private void pngSelected() {
        assert mMeasurableImageView != null;
        mMeasurableImageView.setImageResource(R.drawable.placeholder_png);
    }
}
