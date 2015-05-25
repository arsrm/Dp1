package dao;

import Model.Client;
import java.util.List;

public interface DaoClient {

    public List<Client> clientQry();
    
    public List<Client> clientQry_search(String dni , String name);
    
    public String clientIns(Client client);
    
    public String clientDel(List<String> ids);
    
    public Client clientGet(String idclient);
    
    public String clientUpd(Client client);
    
    
}

