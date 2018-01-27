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
    }

    public void click2(View v)
    {
        String pid="1";
        ActionDAO dao=new ActionDAO(this);
        ArrayList<Action> actions=dao.getActions(pid);
        Game total=new Game(pid,0,"");//總合
        ArrayList<Game> games=new ArrayList<>();
        //先指定第一筆資料
        int section=actions.get(0).getSection();
        String number=actions.get(0).getNumber();
        int count=0;
        games.add(new Game(pid,section,number));

        for(int i=0;i<actions.size();i++)
        {
            //Log.d("action",mylist.get(i).toString());
            if(section!=actions.get(i).getSection() || !actions.get(i).getNumber().equals(number) ){
                section=actions.get(i).getSection();
                number=actions.get(i).getNumber();
                games.add(new Game(pid,section,number));
                count++;
            }
            switch(actions.get(i).getMove())
            {
                case RecordAction.Action_2point_in:
                    games.get(count).setPoint2in(games.get(count).getPoint2in()+1);
                    games.get(count).setScore(games.get(count).getScore()+2);
                    total.setPoint2in(total.getPoint2in()+1);
                    total.setScore(total.getScore()+2);
                    break;
                case RecordAction.Action_2point_out:
                    games.get(count).setPoint2out(games.get(count).getPoint2out()+1);
                    total.setPoint2out(total.getPoint2out()+1);
                    break;
                case RecordAction.Action_3point_in:
                    games.get(count).setPoint3in(games.get(count).getPoint3in()+1);
                    games.get(count).setScore(games.get(count).getScore()+3);
                    total.setPoint3in(total.getPoint3in()+1);
                    total.setScore(total.getScore()+3);
                    break;
                case RecordAction.Action_3point_out:
                    games.get(count).setPoint3out(games.get(count).getPoint3out()+1);
                    total.setPoint3out(total.getPoint3out()+1);
                    break;
                case RecordAction.Action_FT_in:
                    games.get(count).setFtin(games.get(count).getFtin()+1);
                    games.get(count).setScore(games.get(count).getScore()+1);
                    total.setFtin(total.getFtin()+1);
                    total.setScore(total.getScore()+1);
                    break;
                case RecordAction.Action_FT_out:
                    games.get(count).setFtout(games.get(count).getFtout()+1);
                    total.setFtout(total.getFtout()+1);
                    break;
                case RecordAction.Action_OR:
                    games.get(count).setOr(games.get(count).getOr()+1);
                    total.setOr(total.getOr()+1);
                    break;
                case RecordAction.Action_DR:
                    games.get(count).setDr(games.get(count).getDr()+1);
                    total.setDr(total.getDr()+1);
                    break;
                case RecordAction.Action_ST:
                    games.get(count).setSt(games.get(count).getSt()+1);
                    total.setSt(total.getSt()+1);
                    break;
                case RecordAction.Action_AS:
                    games.get(count).setAs(games.get(count).getAs()+1);
                    total.setAs(total.getAs()+1);
                    break;
                case RecordAction.Action_BS:
                    games.get(count).setBs(games.get(count).getBs()+1);
                    total.setBs(total.getBs()+1);
                    break;
                case RecordAction.Action_TO:
                    games.get(count).setTo(games.get(count).getTo()+1);
                    total.setTo(total.getTo()+1);
                    break;
                case RecordAction.Action_Foul:
                    games.get(count).setFoul(games.get(count).getFoul()+1);
                    total.setFoul(total.getFoul()+1);
                    break;
            }
        }
        for(int i=0;i<games.size();i++)
        {
            Log.d("Game",games.get(i).toString());
        }
        Log.d("Total",total.toString());
    }

    public void clickTest(View v)
    {
        ActionDAO dao=new ActionDAO(MainActivity.this);
        Action action=new Action("1",1,"7",9);
        dao.insertAction(action);
        action=new Action("1",2,"7",7);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",7);
        dao.insertAction(action);
        action=new Action("1",1,"14",4);
        dao.insertAction(action);
        action=new Action("1",2,"14",13);
        dao.insertAction(action);
        action=new Action("1",3,"8",13);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"14",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",8);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"8",7);
        dao.insertAction(action);
        action=new Action("1",4,"7",2);
        dao.insertAction(action);
        action=new Action("1",3,"7",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",9);
        dao.insertAction(action);
        action=new Action("1",1,"8",13);
        dao.insertAction(action);
        action=new Action("1",1,"7",7);
        dao.insertAction(action);
        action=new Action("1",2,"8",12);
        dao.insertAction(action);
        action=new Action("1",3,"14",4);
        dao.insertAction(action);
        action=new Action("1",4,"7",12);
        dao.insertAction(action);
        action=new Action("1",1,"14",12);
        dao.insertAction(action);
        action=new Action("1",2,"7",13);
        dao.insertAction(action);
        action=new Action("1",3,"6",11);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"7",2);
        dao.insertAction(action);
        action=new Action("1",2,"7",9);
        dao.insertAction(action);
        action=new Action("1",3,"7",7);
        dao.insertAction(action);
        action=new Action("1",4,"8",10);
        dao.insertAction(action);
        action=new Action("1",1,"8",2);
        dao.insertAction(action);
        action=new Action("1",2,"8",9);
        dao.insertAction(action);
        action=new Action("1",3,"7",13);
        dao.insertAction(action);
        action=new Action("1",4,"14",3);
        dao.insertAction(action);
        action=new Action("1",1,"8",12);
        dao.insertAction(action);
        action=new Action("1",2,"7",2);
        dao.insertAction(action);
        action=new Action("1",3,"7",2);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"14",8);
        dao.insertAction(action);
        action=new Action("1",2,"7",12);
        dao.insertAction(action);
        action=new Action("1",3,"8",9);
        dao.insertAction(action);
        action=new Action("1",4,"8",2);
        dao.insertAction(action);
        action=new Action("1",1,"7",1);
        dao.insertAction(action);
        action=new Action("1",2,"8",1);
        dao.insertAction(action);
        action=new Action("1",3,"8",13);
        dao.insertAction(action);
        action=new Action("1",4,"7",7);
        dao.insertAction(action);
        action=new Action("1",1,"8",4);
        dao.insertAction(action);
        action=new Action("1",2,"8",12);
        dao.insertAction(action);
        action=new Action("1",3,"8",9);
        dao.insertAction(action);
        action=new Action("1",4,"7",9);
        dao.insertAction(action);
        action=new Action("1",1,"7",13);
        dao.insertAction(action);
        action=new Action("1",2,"14",4);
        dao.insertAction(action);
        action=new Action("1",3,"7",7);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"8",13);
        dao.insertAction(action);
        action=new Action("1",2,"7",13);
        dao.insertAction(action);
        action=new Action("1",3,"8",2);
        dao.insertAction(action);
        action=new Action("1",4,"7",8);
        dao.insertAction(action);
        action=new Action("1",1,"8",2);
        dao.insertAction(action);
        action=new Action("1",2,"14",13);
        dao.insertAction(action);
        action=new Action("1",3,"3",12);
        dao.insertAction(action);
        action=new Action("1",4,"7",2);
        dao.insertAction(action);
        action=new Action("1",1,"8",10);
        dao.insertAction(action);
        action=new Action("1",2,"14",4);
        dao.insertAction(action);
        action=new Action("1",3,"16",10);
        dao.insertAction(action);
        action=new Action("1",4,"20",1);
        dao.insertAction(action);
        action=new Action("1",1,"20",2);
        dao.insertAction(action);
        action=new Action("1",2,"20",2);
        dao.insertAction(action);
        action=new Action("1",3,"20",4);
        dao.insertAction(action);
        action=new Action("1",4,"20",4);
        dao.insertAction(action);
        action=new Action("1",2,"20",10);
        dao.insertAction(action);
        action=new Action("1",3,"20",10);
        dao.insertAction(action);
        action=new Action("1",4,"20",9);
        dao.insertAction(action);
        action=new Action("1",1,"20",9);
        dao.insertAction(action);
        action=new Action("1",2,"20",7);
        dao.insertAction(action);
        action=new Action("1",3,"24",1);
        dao.insertAction(action);
        action=new Action("1",4,"24",1);
        dao.insertAction(action);
        action=new Action("1",1,"24",2);
        dao.insertAction(action);
        action=new Action("1",2,"24",2);
        dao.insertAction(action);
        action=new Action("1",3,"24",2);
        dao.insertAction(action);
        action=new Action("1",4,"24",2);
        dao.insertAction(action);
        action=new Action("1",1,"24",2);
        dao.insertAction(action);
        action=new Action("1",2,"24",2);
        dao.insertAction(action);
        action=new Action("1",3,"24",2);
        dao.insertAction(action);
        action=new Action("1",4,"24",2);
        dao.insertAction(action);
        action=new Action("1",1,"24",3);
        dao.insertAction(action);
        action=new Action("1",2,"24",3);
        dao.insertAction(action);
        action=new Action("1",3,"24",4);
        dao.insertAction(action);
        action=new Action("1",4,"24",4);
        dao.insertAction(action);
        action=new Action("1",1,"24",4);
        dao.insertAction(action);
        action=new Action("1",2,"24",5);
        dao.insertAction(action);
        action=new Action("1",3,"24",5);
        dao.insertAction(action);
        action=new Action("1",4,"24",6);
        dao.insertAction(action);
        action=new Action("1",1,"24",6);
        dao.insertAction(action);
        action=new Action("1",2,"24",10);
        dao.insertAction(action);
        action=new Action("1",3,"24",10);
        dao.insertAction(action);
        action=new Action("1",4,"24",9);
        dao.insertAction(action);
        action=new Action("1",1,"24",9);
        dao.insertAction(action);
        action=new Action("1",2,"24",9);
        dao.insertAction(action);
        action=new Action("1",1,"24",13);
        dao.insertAction(action);
        action=new Action("1",4,"24",7);
        dao.insertAction(action);
        action=new Action("1",1,"24",7);
        dao.insertAction(action);
        action=new Action("1",2,"24",8);
        dao.insertAction(action);
        action=new Action("1",3,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",1,"24",12);
        dao.insertAction(action);
        action=new Action("1",2,"24",12);
        dao.insertAction(action);
        action=new Action("1",3,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",4,"24",12);
        dao.insertAction(action);
        action=new Action("1",3,"25",1);
        dao.insertAction(action);
        action=new Action("1",2,"25",1);
        dao.insertAction(action);
        action=new Action("1",1,"25",1);
        dao.insertAction(action);
        action=new Action("1",1,"25",2);
        dao.insertAction(action);
        action=new Action("1",2,"25",2);
        dao.insertAction(action);
        action=new Action("1",3,"25",4);
        dao.insertAction(action);
        action=new Action("1",4,"25",5);
        dao.insertAction(action);
        action=new Action("1",1,"25",5);
        dao.insertAction(action);
        action=new Action("1",2,"25",5);
        dao.insertAction(action);
        action=new Action("1",3,"25",6);
        dao.insertAction(action);
        action=new Action("1",4,"25",6);
        dao.insertAction(action);
        action=new Action("1",1,"25",9);
        dao.insertAction(action);
        action=new Action("1",2,"25",8);
        dao.insertAction(action);
        action=new Action("1",3,"25",8);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",1,"25",12);
        dao.insertAction(action);
        action=new Action("1",2,"25",12);
        dao.insertAction(action);
        action=new Action("1",3,"25",12);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",4,"25",12);
        dao.insertAction(action);
        action=new Action("1",2,"25",13);
        dao.insertAction(action);
        action=new Action("1",1,"25",13);
        dao.insertAction(action);
        action=new Action("1",3,"25",13);
        dao.insertAction(action);
        action=new Action("1",4,"25",13);
        dao.insertAction(action);
        action=new Action("1",1,"17",12);
        dao.insertAction(action);

    }
}
