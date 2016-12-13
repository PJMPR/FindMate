package dao;

/**
 * Created by Mela on 2016-12-06.
 */
public interface IRepositoryCatalog {
    public IAccountRepository users();
    public IProfileRepository profiles();
    public ILikeRepository likes();

    public void saveAndClose();
    public void save();
}
