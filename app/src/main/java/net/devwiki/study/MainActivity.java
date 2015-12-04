package net.devwiki.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_context_info:
                intent = new Intent(MainActivity.this, ContextActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_record:
                intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
