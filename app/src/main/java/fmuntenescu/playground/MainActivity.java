package fmuntenescu.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fmuntenescu.playground.animations.AnimationPlaygroundActivity;
import fmuntenescu.playground.vectordrawables.VectorDrawablesPlaygroundActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View startAnimationsPlayground = findViewById(R.id.animations_playground_button);

        assert startAnimationsPlayground != null;
        startAnimationsPlayground
                .setOnClickListener(v -> startActivity(AnimationPlaygroundActivity.class));

        View startVectorDrawablesPlayground = findViewById(
                R.id.vector_drawables_playground_button);

        assert startVectorDrawablesPlayground != null;
        startVectorDrawablesPlayground
                .setOnClickListener(v -> startActivity(VectorDrawablesPlaygroundActivity.class));
    }

    private void startActivity(@NonNull final Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
