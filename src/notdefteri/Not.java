/**
 *
 * @author Erdinç Ocak
 */
package notdefteri;

public class Not {

    private int dbId;
    private String dbBaslik;
    private String dbGovde;

    public Not(int dbId, String dbBaslik, String dbGovde) {
        this.dbId = dbId;
        this.dbBaslik = dbBaslik;
        this.dbGovde = dbGovde;
    }
    
    private Not(){}

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public String getDbBaslik() {
        return dbBaslik;
    }

    public void setDbBaslik(String dbBaslik) {
        this.dbBaslik = dbBaslik;
    }

    public String getDbGovde() {
        return dbGovde;
    }

    public void setDbGovde(String dbGovde) {
        this.dbGovde = dbGovde;
    }
    
    

}
