package zeev.fraiman.customdesigncollections;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DinamicSinus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_sinus);

        CustomSinusView customSinusView = new CustomSinusView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                (int) getResources().getDisplayMetrics().density * 400,
                (int) getResources().getDisplayMetrics().density * 300
        );
        customSinusView.setLayoutParams(params);

        setContentView(customSinusView);

    }
}