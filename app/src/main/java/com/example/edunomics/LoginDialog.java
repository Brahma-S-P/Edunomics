package com.example.edunomics;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;



public class LoginDialog extends AppCompatDialogFragment {

    private EditText editTextemail;
    private EditText editTextpassword;
    private LoginDialogListenerFull listener;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.login_dialog, null);

        editTextemail= view.findViewById(R.id.edit_email);
        editTextpassword = view.findViewById(R.id.edit_password);






        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String favoriteemail= editTextemail.getText().toString();
                        String favoritepassword = editTextpassword.getText().toString();
                        listener.applyTextsfull(favoriteemail,favoritepassword);
                    }
                });




        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (LoginDialogListenerFull) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface LoginDialogListenerFull {
        void applyTextsfull(String favoriteemail, String favoritepassword);
    }
}