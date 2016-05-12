package fmuntenescu.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import fmuntenescu.playground.animations.AnimationPlaygroundActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.animations_playground_button);

        assert view != null;
        view.setOnClickListener(v -> startActivity(AnimationPlaygroundActivity.class));
    }

    private void startActivity(@NonNull final Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
