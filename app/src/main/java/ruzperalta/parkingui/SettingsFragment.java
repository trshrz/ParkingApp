package ruzperalta.parkingui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SettingsFragment extends Fragment {

    EditText etNewPw;
    EditText etConfirm;
//    EditText etOldPw;
    Button btnChange;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
//        etOldPw = view.findViewById(R.id.changeOldPass);
        etNewPw = view.findViewById(R.id.changeNewPass);
        etConfirm = view.findViewById(R.id.changeConfirm);
        btnChange = view.findViewById(R.id.btnChangePass);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        final String email = user.getEmail();
//        final String oldpass = etOldPw.getText().toString().trim();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newpass = etNewPw.getText().toString().trim();
                String confirm = etConfirm.getText().toString().trim();
//                Toast.makeText(getContext(), "" + email, Toast.LENGTH_SHORT).show();
                if(newpass.isEmpty() || confirm.isEmpty()){
                    if(newpass.isEmpty()){
                        etNewPw.setError("Please fill up this field.");
                    }
                    if(confirm.isEmpty()){
                        etConfirm.setError("Please fill up this field.");
                    }
                }else{
                    if(newpass.equals(confirm)){
                        if(newpass.length() >= 6){
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            user.updatePassword(newpass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(getContext(), "Password change failed", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getContext(), "Password Successfully Modified", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else{
                            if(newpass.length() < 6){
                                etNewPw.setError("Password must be at least 6 characters");
                            }
                            if(confirm.length() < 6){
                                etConfirm.setError("Password must be at least 6 characters");
                            }
                        }
                    }else{
                        Toast.makeText(getContext(), "Passwords do not match, please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}
