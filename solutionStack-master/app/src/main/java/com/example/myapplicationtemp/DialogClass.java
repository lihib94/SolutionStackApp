package com.example.myapplicationtemp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogClass extends AppCompatDialogFragment {

    int WhereDidComeFrom = 0;

    public DialogClass (int WhereDidComeFrom){
        this.WhereDidComeFrom = WhereDidComeFrom;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //forgot your password
        if(this.WhereDidComeFrom == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Hi Student")
                    .setMessage("The password was sent to your E-mail")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

            return builder.create();
        }
        else if(this.WhereDidComeFrom == 2){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("What is your choice?")
                    .setMessage("Please select:")
                    .setPositiveButton("Take a Picture", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,0);
                        }
                    })
                    .setNegativeButton("Upload a file", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            openStoragePage();
                        }
                    });
            return builder.create();
        }
        else{
            return null;
        }
    }

    public void openStoragePage() {
        Intent intent = new Intent(DialogClass.this.getActivity(), StoragePage.class);
        startActivity(intent);
    }

}
