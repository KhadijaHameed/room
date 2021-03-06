package com.example.palindrome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomwrapperimplement.R;
import com.example.screens.ForgotPassword;
import com.example.screens.Home;
import com.example.screens.HomeScreen_two;
import com.example.screens.Homescreen;
import com.example.screens.Navigation;
import com.example.screens.ScreenSplash;
import com.example.screens.Setting;


public class PalindromeMainActivity extends AppCompatActivity {


    EditText word;
    Button check;
    int r; //remainder
    int sum = 0;// reversedInteger
    int temp;  //originalInteger
    int n;//It is the number variable to be checked for palindrome

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palindrome_activity_main);

         initViews();
        checkIfPalindrome();

       }

    private void initViews() {
        word = (EditText) findViewById(R.id.et_word);
        check = (Button) findViewById(R.id.btn_check);
    }

    private void checkIfPalindrome() {
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // CHECKED INTEGER PALINDROME
                n = Integer.parseInt(word.getText().toString());
                temp = n;   // originalInteger = num;
                while (n > 0) {
                    r = n % 10;  //getting remainder
                    sum = (sum * 10) + r;
                    n = n / 10;
                }
                if (temp == sum) {
                    System.out.println("palindrome number ");
                } else {
                    System.out.println("not palindrome");
                }

                // CHECKED STRING PALINDROME
                String original, reverse = ""; // Objects of String class
                original = word.getText().toString();
                int length = original.length();
                for (int i = length - 1; i >= 0; i--)
                    reverse = reverse + original.charAt(i);
                if (original.equals(reverse)) {
                    Log.d("test", "!!!!   original: " + original + "reverse: " + reverse);
                    Toast.makeText(PalindromeMainActivity.this, "This is palindrome", Toast.LENGTH_LONG).show();
                } else {

                    Log.d("test", "xxxx original: " + original + "reverse: " + reverse);
                    Toast.makeText(PalindromeMainActivity.this, "This isn't palindrome", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
