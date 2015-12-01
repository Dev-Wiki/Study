package net.devwiki.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.devwiki.study.log.DevLog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_context_info);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_context_info:
                Intent intent = new Intent(MainActivity.this, ContextActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
