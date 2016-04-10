package id.dekz.code.rxexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.dekz.code.rxexample.act.Example1;
import id.dekz.code.rxexample.act.Example2;

public class MainActivity extends AppCompatActivity {

    Button example1,example2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example1 = (Button) findViewById(R.id.ex1);
        example1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x1 = new Intent(MainActivity.this, Example1.class);
                startActivity(x1);
            }
        });

        example2 = (Button) findViewById(R.id.ex2);
        example2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x2 = new Intent(MainActivity.this, Example2.class);
                startActivity(x2);
            }
        });
    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}
