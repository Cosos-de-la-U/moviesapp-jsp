package Interfaces;

import java.util.List;

public interface iCrud {
    public Object select();
    public List<Object> selectAll();
    public boolean insert();
    public boolean edit();
    public boolean delete();
}
