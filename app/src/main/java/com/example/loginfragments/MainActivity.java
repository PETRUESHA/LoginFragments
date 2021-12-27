package com.example.loginfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginfragments.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText LoginField;
    private EditText PasswordField;
    private Button btn1, btn2;
    public static final String KEY = "key";
    private static final String LOGIN = "petr";
    private static final String PASSWORD = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        LoginField = binding.editLogin;
        PasswordField = binding.editPassword;
        TextView error = binding.errorText;
        error.setVisibility(View.INVISIBLE);
        btn1 = binding.button2;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginField.setText(null);
                PasswordField.setText(null);
            }
        });
        btn2 = binding.button;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(LoginField) & !isEmpty(PasswordField)) {
                    String login = LoginField.getText().toString();
                    String password = PasswordField.getText().toString();
                    if (login.equals(LOGIN) & password.equals(PASSWORD)) {
                        loadFragment(new Fragment1(), login);
                        error.setVisibility(View.INVISIBLE);
                    }
                    else {
                        error.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void loadFragment(Fragment f, String log) {
        FragmentManager fragmentMenanger = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        Log.d("NNN", log);
        bundle.putString(KEY, log);
        f.setArguments(bundle);

        FragmentTransaction fragmentTransaction = fragmentMenanger.beginTransaction();
        fragmentTransaction.replace(R.id.FragmentBody, f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private boolean isEmpty(EditText myEditText) {
        return myEditText.getText().toString().trim().length() == 0;
    }
}