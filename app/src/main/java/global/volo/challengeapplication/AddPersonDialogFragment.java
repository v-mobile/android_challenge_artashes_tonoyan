package global.volo.challengeapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by artashes on 9/19/17.
 */

public class AddPersonDialogFragment extends DialogFragment {

    AddPersonListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_add_person, null);
        final EditText firstName = (EditText) view.findViewById(R.id.first_name);
        final EditText lastName = (EditText) view.findViewById(R.id.last_name);
        builder.setView(view)
                .setPositiveButton(R.string.dialog_positive_button_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (firstName.getText().length() == 0
                                || lastName.getText().length() == 0) {
                            return;
                        }

                        String firstNameString = firstName.getText().toString();
                        firstNameString = firstNameString.substring(0, 1).toUpperCase() + firstNameString.substring(1);
                        String lastNameString = lastName.getText().toString();
                        lastNameString = lastNameString.substring(0, 1).toUpperCase() + lastNameString.substring(1);



                        mListener.onAddPerson(new Person(firstNameString, lastNameString));
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (AddPersonListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement AddPersonListener");
        }
    }

    public interface AddPersonListener {
        void onAddPerson(Person person);
    }
}