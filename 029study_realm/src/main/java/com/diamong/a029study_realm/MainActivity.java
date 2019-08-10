package com.diamong.a029study_realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<Realm> {
    private Realm mRealm;

    private EditText mEmail, mPassword, mNewPassword;
    private TextView mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email_edit);
        mPassword = findViewById(R.id.password_edit);
        mNewPassword = findViewById(R.id.new_password_edit);
        mResult = findViewById(R.id.result_text);

        mRealm = Realm.getDefaultInstance();
        mRealm.addChangeListener(this);
        showResult();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    public void signIn(View view) {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        User user = mRealm.where(User.class)
                .equalTo("email", email)
                .equalTo("password", password)
                .findFirst();

        if (user != null) {
            Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show();
        }

    }

    public void signUp(View view) {
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                if (realm.where(User.class).equalTo("email",
                        mEmail.getText().toString()).count() > 0) {
                    realm.cancelTransaction();
                }

                User user = realm.createObject(User.class);
                user.setEmail(mEmail.getText().toString());
                user.setPassword(mPassword.getText().toString());

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivity.this, "실패:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updatePassword(View view) {
        final User user = mRealm.where(User.class)
                .equalTo("email", mEmail.getText().toString())
                .findFirst();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                user.setPassword(mNewPassword.getText().toString());
            }
        });

    }

    public void deleteAccount(View view) {
        final RealmResults<User> results = mRealm.where(User.class)
                .equalTo("email", mEmail.getText().toString())
                .findAll();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                results.deleteAllFromRealm();
            }
        });

    }

    private void showResult() {
        RealmResults<User> users = mRealm.where(User.class).findAll();
        mResult.setText(users.toString());
    }

    @Override
    public void onChange(Realm realm) {
        showResult();
    }
}
