package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DQL {

//    public DQL getFromId(Comparable id) throws ClassNotFoundException, SQLException;

    public ArrayList getResultSet() throws ClassNotFoundException, SQLException;
}
