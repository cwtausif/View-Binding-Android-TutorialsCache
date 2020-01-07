package com.tutorialscache.viewbindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tutorialscache.viewbindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String name,email,city;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        /*adding click listner to Button by using binding object with id button
         *which we added in layout file
         */
        binding.button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                /*retreiving the input from edittext and setting it to given
                 *stings for further use
                 */
                name=binding.nameEdit.getText().toString();
                email=binding.emailEdit.getText().toString();
                city=binding.cityEdit.getText().toString();
                //check id stings are empty in edittext
                if (name.isEmpty()||email.isEmpty()||city.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Empty Fields",Toast.LENGTH_SHORT).show();
                }
                // if not then set textviews to given stings
                else {
                    binding.nameTv.setText("Your Name: " + name);
                    binding.emailTv.setText("Your Email: " + email);
                    binding.cityTv.setText("Your City: " + city);
                }
            }
        });
    }
}
