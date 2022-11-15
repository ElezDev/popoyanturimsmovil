package com.adsi5226.popayanturims;

import android.os.Bundle;

import com.adsi5226.popayanturims.databinding.ActivityUsersBinding;

public class UsersActivity extends DrawerBaseActivity {

 ActivityUsersBinding activityUsersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUsersBinding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(activityUsersBinding.getRoot());
        allocateActivityTitle("Users");
    }
}