package com.foxhole.fireabasecrudmvp.Core;

import com.foxhole.fireabasecrudmvp.Model.Player;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public interface MainActivityContract {

    interface View{
        void onCreatePlayerSuccessful();
        void onCreatePlayerFailure();
        void onProcessStart();
        void onProcessEnd();
        void onPlayerRead(ArrayList<Player>players);
        void onPlayerUpdate(Player player);
        void onPlayerDelete(Player player);
    }

    interface Presenter{
        void createNewPlayer(DatabaseReference reference, Player player);
        void readPlayers(DatabaseReference reference);
        void updatePlayer(DatabaseReference reference, Player player);
        void deletePlayer(DatabaseReference reference, Player player);
    }

    interface Ineractor{
        void performCreatePlayer(DatabaseReference reference, Player player);
        void performReadPlayers(DatabaseReference reference);
        void performUpdatePlayer(DatabaseReference reference,Player player);
        void performDeletePlayer(DatabaseReference reference, Player player);
    }

    interface onOperationListener{
        void onSuccess();
        void onFailure();
        void onStart();
        void onEnd();
        void onRead(ArrayList<Player> players);
        void onUpdate(Player player);
        void onDelete(Player player);
    }
}
