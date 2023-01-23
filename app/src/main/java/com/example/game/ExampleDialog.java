package com.example.game;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    private Code co;
    private int code;


    public ExampleDialog(Code co, int code) {
        this.co = co;
        this.code = code;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        if (code == 1){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("code 1")
                    .setMessage("congratulations you found the first code: "+String.valueOf(co.getCode1()))
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            return builder.create();

        }
        else
        if (code == 2){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Code 2")
                    .setMessage("Nice you beet the game here is the second code: "+String.valueOf(co.getCode2()))
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            return builder.create();
        }else
            if(code == 3){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("code 3")
                        .setMessage("hmm that does seem like a right code does it?: "+Integer.toBinaryString(co.getCode3()))
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), "Code copied to clipboard", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("hint", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), "try to decode this code from binary to decimal", Toast.LENGTH_SHORT).show();
                                Toast.makeText(getActivity(), "Code copied to clipboard", Toast.LENGTH_SHORT).show();
                            }
                        });

                return builder.create();

            }else
                if (code == 4){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("code 4")
                            .setMessage("Good job you found the last code "+String.valueOf(co.getCode4()))
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                    return builder.create();
                }
        return null;
    }

}
