package BL;

import DB_Firebase.FactoryDB;
import Models.IDB_Operations;
import Models.IFactoryBL;
import Models.IFactoryDB;
import Models.Operations;

public class FactoryBL implements IFactoryBL {
    public Operations getOperations() {
        IFactoryDB obj = new FactoryDB();

        IDB_Operations DB = obj.getDB();
        String ID = obj.getID();
        Operations op = new BL_Operations(DB, ID);

        return op;
    }
}
