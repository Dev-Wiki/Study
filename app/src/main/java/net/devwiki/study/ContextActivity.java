package net.devwiki.study;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;

/**
 * Context信息
 * Created by Asia on 2015/12/1 0001.
 */
public class ContextActivity extends AppCompatActivity{

    private TextView infoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        infoView = (TextView) findViewById(R.id.context_info);

        infoView.append("getPackageName:");
        infoView.append(getPackageName());
        infoView.append("\n");

        infoView.append("getPackageCodePath:");
        infoView.append(getPackageCodePath());
        infoView.append("\n");

        infoView.append("getPackageResourcePath:");
        infoView.append(getPackageResourcePath());
        infoView.append("\n");

        infoView.append("getCacheDir:");
        infoView.append(getCacheDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getFilesDir:");
        infoView.append(getFilesDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getNoBackupFilesDir:");
        infoView.append(getNoBackupFilesDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getExternalFilesDir-Music:");
        infoView.append(getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        infoView.append("\n");

        infoView.append("getExternalFilesDir-Alarms:");
        infoView.append(getExternalFilesDir(Environment.DIRECTORY_ALARMS).getAbsolutePath());
        infoView.append("\n");

        infoView.append("getExternalFilesDirs:");
        File[] files = getExternalFilesDirs(Environment.DIRECTORY_MUSIC);
        for (File file : files){
            infoView.append(file.getAbsolutePath());
            infoView.append("\n");
        }
        infoView.append("\n");

        infoView.append("getObbDir:");
        infoView.append(getObbDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getObbDirs:");
        files = getObbDirs();
        for (File file : files){
            infoView.append(file.getAbsolutePath());
            infoView.append("\n");
        }
        infoView.append("\n");

        infoView.append("getCacheDir:");
        infoView.append(getCacheDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getCodeCacheDir:");
        infoView.append(getCodeCacheDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getExternalCacheDir:");
        infoView.append(getExternalCacheDir().getAbsolutePath());
        infoView.append("\n");

        infoView.append("getExternalCacheDirs:");
        files = getExternalCacheDirs();
        for (File file : files){
            infoView.append(file.getAbsolutePath());
            infoView.append("\n");
        }
        infoView.append("\n");

        infoView.append("getExternalMediaDirs:");
        files = getExternalMediaDirs();
        for (File file : files){
            infoView.append(file.getAbsolutePath());
            infoView.append("\n");
        }
        infoView.append("\n");

        infoView.append("fileList:");
        String[] fileList = fileList();
        for (String string : fileList){
            infoView.append(string);
            infoView.append("\n");
        }
        infoView.append("\n");
    }
}
