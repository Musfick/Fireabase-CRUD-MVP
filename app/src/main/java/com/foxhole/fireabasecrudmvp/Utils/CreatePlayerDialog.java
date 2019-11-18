package com.foxhole.fireabasecrudmvp.Utils;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.foxhole.fireabasecrudmvp.Model.Player;
import com.foxhole.fireabasecrudmvp.R;

public class CreatePlayerDialog extends AppCompatDialogFragment {

    public EditText mName;
    public EditText mAge;
    public EditText mPosition;
    public Button mSaveBtn;
    public createPlayerDialogListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view);
        builder.setTitle("Add New Player");
        builder.setCancelable(true);

        mName = (EditText)view.findViewById(R.id.et_name);
        mAge = (EditText)view.findViewById(R.id.et_age);
        mPosition = (EditText)view.findViewById(R.id.et_position);
        mSaveBtn = (Button)view.findViewById(R.id.btn_save);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mName.getText().toString();
                String age = mAge.getText().toString();
                String position = mPosition.getText().toString();

                if(name.isEmpty() || age.isEmpty() || position.isEmpty())
                {
                    return;
                }
                else
                {
                    Player player = new Player(name,age,position);
                    mListener.savePlayer(player);
                    dismiss();

                }

            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (createPlayerDialogListener) context;
    }

    public interface createPlayerDialogListener{
        void savePlayer(Player player);
    }
}
