package com.matcha.testaddlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.matcha.testaddlayout.dao.Action;
import com.matcha.testaddlayout.dao.ActionDAO;
import com.matcha.testaddlayout.dao.Game;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String pid="1";
        ActionDAO dao=new ActionDAO(this);
        ArrayList<Action> mylist=dao.getActions(pid);
        ArrayList<Game> games=new ArrayList<>();
        int section=mylist.get(0).getSection();
        String number=mylist.get(0).getNumber();
        int count=0;
        games.add(new Game(pid,section,number));

        for(int i=0;i<mylist.size();i++)
        {
            Log.d("action",mylist.get(i).toString());
            if(section!=mylist.get(i).getSection() || !mylist.get(i).getNumber().equals(number) ){
                section=mylist.get(i).getSection();
                number=mylist.get(i).getNumber();
                games.add(new Game(pid,section,number));
                count++;
            }
            switch(mylist.get(i).getMove())
            {
                case RecordAction.Action_2point_in:
                    games.get(count).setPoint2in(games.get(count).getPoint2in()+1);
                    games.get(count).setScore(games.get(count).getScore()+2);
                    break;
            }
        }
        for(int i=0;i<games.size();i++)
        {
            Log.d("Game",games.get(i).toString());

        }


    }

    public void clickTest(View v)
    {
        ActionDAO dao=new ActionDAO(MainActivity.this);
        Action action=new Action("1",1,"23",6);
        dao.insertAction(action);
        action=new Action("1",1,"40",8);
        dao.insertAction(action);
        action=new Action("1",1,"35",3);
        dao.insertAction(action);
        action=new Action("1",1,"20",2);
        dao.insertAction(action);
        action=new Action("1",1,"35",5);
        dao.insertAction(action);
        action=new Action("1",1,"40",1);
        dao.insertAction(action);
        action=new Action("1",1,"20",3);
        dao.insertAction(action);
        action=new Action("1",1,"35",5);
        dao.insertAction(action);
        action=new Action("1",2,"40",7);
        dao.insertAction(action);
        action=new Action("1",2,"20",2);
        dao.insertAction(action);
        action=new Action("1",2,"35",1);
        dao.insertAction(action);
        action=new Action("1",2,"40",2);
        dao.insertAction(action);


    }
}
