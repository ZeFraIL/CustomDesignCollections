package zeev.fraiman.customdesigncollections;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyToast {
    public static void showToast(Context context, String message, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_toast, null);

        ImageView imageView = view.findViewById(R.id.ivIn);
        TextView textView = view.findViewById(R.id.tvIn);

        if (i==1)
            imageView.setImageResource(R.drawable.welcome_user);
        if (i==2)
            imageView.setImageResource(R.drawable.good_bye);
        textView.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);

        toast.setView(view);
        toast.show();
    }

}
