package com.example.restapiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddData extends AppCompatActivity {
    EditText userName, userEmail, userPassword;
    Button signupButton;
    TextView gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        userName = findViewById(R.id.name);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);

        signupButton = findViewById(R.id.button);

        gotoLogin = findViewById(R.id.gotoLogin);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // processData(userName.getText().toString(),userEmail.getText().toString(),userPassword.getText().toString());
            }
        });
    }
    private void processData(String name, String email, String password) {
        // call getRegister Api
        Call<ResponseModel> call = ApiController.getInstance().getApi().getRegister(name, email, password);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                ResponseModel model = response.body();
                Toast.makeText(getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT).show();
                userName.setText("");
                userEmail.setText("");
                userPassword.setText("");
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something Went Wrong!!", Toast.LENGTH_SHORT).show();
                userName.setText("");
                userEmail.setText("");
                userPassword.setText("");
            }
        });
    }
}