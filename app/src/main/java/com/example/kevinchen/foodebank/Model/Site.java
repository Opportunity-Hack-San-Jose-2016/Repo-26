package com.example.kevinchen.foodebank.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;

public class Site  {
    private String mLocation;
    private HashMap<String, Event> mEventList;

    public Site (String location) {
        mEventList = new HashMap<String, Event>();
        mLocation = location;
    }

    public String getLocation() {
        return mLocation;
    }

    public boolean addEvent(String json) {
//        {"date":"07-01-2016-14:00",
//         "participants" : [
//              {"name":"Amy", "id":"1234","load":"10lb"},
//              {"name":"Bob", "id":"1235","load":"7lb"},
//              {"name":"Carl", "id":"1236","load":"5lb"},
//         }]}
        try {
            JSONObject data = new JSONObject(json);
            String date = data.getString("date");
            Event event = new Event(date);
            mEventList.put(date, event);

            JSONArray participants = data.getJSONArray("participants");
            for (int index=0; index<participants.length(); index++) {
                String name = participants.getJSONObject(index).getString("name");
                String id = participants.getJSONObject(index).getString("id");
                String load = participants.getJSONObject(index).getString("load");
                event.addParticipant(name, id, load);
            }
            return true;
        } catch (JSONException e) {
            System.out.println(e);
            return false;
        }
    }

    public void removeEvent(String date) {
        if (mEventList.get(date)!=null) {
            mEventList.remove(mEventList.get(date));
        }
    }

    public boolean addParticipantToEvent(String time, String name, String id, String load) {
        Event event = mEventList.get(time);
        return event.addParticipant(name, id, load);
    }

    public void removeParticipantFromEvent(String time, String id) {
        if (mEventList.get(time)!=null && mEventList.get(time).getParticipants()!=null &&
                mEventList.get(time).getParticipants().get(id)!=null) {
            mEventList.get(time).getParticipants().remove(id);
        }
    }

    public Event getEvent(String date) {
        return mEventList.get(date);
    }


}
