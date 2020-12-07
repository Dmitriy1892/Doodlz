package com.coldfier.doodlz;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class EraseImageDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.message_erase);

        builder.setPositiveButton(R.string.button_erase, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getDoodleFragment().getDoodleView().clear();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, null);
        return builder.create();
    }

    private MainActivityFragment getDoodleFragment() {
        return (MainActivityFragment) getFragmentManager().findFragmentById(R.id.doodleFragment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivityFragment fragment = getDoodleFragment();

        if (fragment != null) fragment.setDialogOnScreen(true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MainActivityFragment fragment = getDoodleFragment();

        if (fragment != null) fragment.setDialogOnScreen(false);
    }
}
