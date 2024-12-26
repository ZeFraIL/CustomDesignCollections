package zeev.fraiman.customdesigncollections;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddCustomActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_action_bar);

        // Set up custom ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setCustomView(R.layout.custom_action_bar);
        }
        else {
            Toast.makeText(this, "NULL", Toast.LENGTH_SHORT).show();
        }

        TextView title = findViewById(R.id.action_bar_title);
        ImageView image = findViewById(R.id.action_bar_image);
        VideoView videoView = findViewById(R.id.action_bar_video);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.mvideo; // замените на ваш файл
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.start();

        videoView.setOnCompletionListener(mp -> videoView.start());
    }
}
