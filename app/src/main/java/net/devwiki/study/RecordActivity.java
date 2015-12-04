package net.devwiki.study;

import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.devwiki.study.log.DevLog;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button stopButton;
    private AudioRecord audioRecord;
    private boolean isRecording = false;
    private int bufferSize;
    private byte[] dataBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        startButton = (Button) findViewById(R.id.record_start);
        startButton.setOnClickListener(this);
        stopButton = (Button) findViewById(R.id.record_stop);
        stopButton.setOnClickListener(this);

        initRecord();

        boolean result = checkPermission("android.permission.RECORD_AUDIO");

        DevLog.d("result:" + result);
    }

    private void initRecord(){
        bufferSize = AudioRecord.getMinBufferSize(44100, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        dataBuffer = new byte[bufferSize];
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, 44100,
                AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.record_start:
                startRecord();
                break;
            case R.id.record_stop:
                stopRecord();
                break;
            default:
                break;
        }
    }

    private void startRecord(){
        DevLog.d("start record!!!");
        isRecording = true;
        audioRecord.startRecording();
        new Thread(volumeRun).start();
    }

    private void stopRecord(){
        DevLog.d("stop record!!!");
        isRecording = false;
        audioRecord.stop();
    }

    private Runnable volumeRun = new Runnable() {
        @Override
        public void run() {
            while(isRecording){
                int size = audioRecord.read(dataBuffer, 0, bufferSize);
                DevLog.d("size:" + size);
                DevLog.d("data:" + byte2hex(dataBuffer));
            }
        }
    };

    private static String byte2hex(byte [] buffer){
        String h = "";

        for(int i = 0; i < buffer.length; i++){
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            if(temp.length() == 1){
                temp = "0" + temp;
            }
            h = h + " "+ temp;
        }
        return h;
    }

    private boolean checkPermission(String permission) {
        int res = checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}
