package zeev.fraiman.customdesigncollections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button bToast, bDialog, bSinus, bActionBar, bToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        bToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.showToast(context,"Welcome!",1);
            }
        });

        bDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(context);

                // Устанавливаем layout для диалога
                final View my_alertdialog = getLayoutInflater().inflate(R.layout.mycontact_dialog, null);
                adb.setView(my_alertdialog);

                // Запрещаем закрытие диалога по нажатию вне области
                adb.setCancelable(false);

                // Создаем диалог
                final AlertDialog ad = adb.create();
                ad.show();

                // Инициализируем элементы внутри layout
                TextView tvTitle = my_alertdialog.findViewById(R.id.tvTitle);
                TextView tvMessage = my_alertdialog.findViewById(R.id.tvMessage);
                Button bSendSMS = my_alertdialog.findViewById(R.id.bSendSMS);
                Button bSendEmail = my_alertdialog.findViewById(R.id.bSendEmail);
                Button bCall = my_alertdialog.findViewById(R.id.bCall);
                Button bUpdate = my_alertdialog.findViewById(R.id.bUpdate);
                Button bDelete = my_alertdialog.findViewById(R.id.bDelete);
                Button bCancel = my_alertdialog.findViewById(R.id.bCancel);
                EditText etEmail = my_alertdialog.findViewById(R.id.etEmail);
                EditText etPhone = my_alertdialog.findViewById(R.id.etPhone);

                tvTitle.setText("For inner contacts");
                tvMessage.setText("Enter data and select an action");

                // Устанавливаем обработчики для кнопок
                bSendSMS.setOnClickListener(view -> {
                    String stPhone = etPhone.getText().toString();
                    // Отправка SMS
                });

                bSendEmail.setOnClickListener(view -> {
                    String stEmailAddress = etEmail.getText().toString();
                    // Отправка Email
                });

                bCall.setOnClickListener(view -> {
                    // Вызов
                });

                bDelete.setOnClickListener(view -> {
                    // Удаление
                });

                bUpdate.setOnClickListener(view -> {
                    // Обновление
                });

                bCancel.setOnClickListener(view -> {
                    ad.dismiss(); // Закрытие диалога
                });
            }
        });


        bSinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(context, DinamicSinus.class);
                startActivity(go);
            }
        });

        bActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(context, AddCustomActionBar.class);
                startActivity(go);
            }
        });

        bToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(context, MyToolbar.class);
                startActivity(go);
            }
        });
    }

    private void initComponents() {
        context=this;
        bToast=findViewById(R.id.bToast);
        bDialog=findViewById(R.id.bDialog);
        bSinus=findViewById(R.id.bSinus);
        bActionBar=findViewById(R.id.bActionBar);
        bToolbar=findViewById(R.id.bToolbar);
    }
}