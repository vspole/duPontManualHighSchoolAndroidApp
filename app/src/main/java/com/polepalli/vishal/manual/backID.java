package com.polepalli.vishal.manual;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import static com.polepalli.vishal.manual.frontId.editor;
import static com.polepalli.vishal.manual.frontId.preferences;

/**
 * Created by visha on 2/14/2017.
 */

public class backID extends AppCompatActivity {
    private Button uButton;
    private ImageView mImageView;
    private static final int CAMERA_REQUEST_CODE = 1;
    private StorageReference mStorage;
    private ProgressDialog mProgress;
    String username;
    Uri downloadUri;
    int done = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_id);
        mStorage = FirebaseStorage.getInstance().getReference();
        uButton = (Button) findViewById(R.id.upload);
        mImageView = (ImageView) findViewById(R.id.imageView2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.Whute));
        toolbar.setTitle(" duPont Manual High School");
        toolbar.setLogo(R.drawable.shield);
        toolbar.setNavigationIcon(R.drawable.close);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        preferences = PreferenceManager.getDefaultSharedPreferences(backID.this);
        editor = preferences.edit();
        downloadUri = Uri.parse(preferences.getString("urlB", ""));
        done = preferences.getInt("doneB",0);
        if(done==1)
        {
            show();
        }
        mProgress = new ProgressDialog(this);
        uButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                askforname();

            }
        });
    }

    protected void askforname()
    {
        final EditText name = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Username")
                .setMessage("Enter your JCPS Username")
                .setView(name)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                         username = name.getText().toString();
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, CAMERA_REQUEST_CODE);
                    }
                })
                .show();


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK)
        {
            mProgress.setMessage("Uploading ID Image...");
            mProgress.show();
            Uri uri = data.getData();
            username = username + "b";
            StorageReference filepath = mStorage.child("Photos").child(username);

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                {
                    mProgress.dismiss();
                    downloadUri = taskSnapshot.getDownloadUrl();
                    //Toast.makeText(frontId.this, "ID Uploaded",Toast.LENGTH_LONG).show();
                    show();
                }
            });
        }
    }
    public void show()
    {
        editor.putString("urlB",downloadUri.toString());
        editor.putInt("doneB",1);
        editor.apply();
        Picasso.with(backID.this).load(downloadUri).fit().centerCrop().into(mImageView);
    }

}
