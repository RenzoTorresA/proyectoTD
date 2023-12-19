package TDmain.Libro.service;

import java.util.List;

import TDmain.Libro.model.modelAutor;

public interface IAuthService {

    public modelAutor add (modelAutor autor);
    public modelAutor update (modelAutor autor);
    public boolean delete (int id);
    public List<modelAutor> findAll ();
    public modelAutor findById (int id);
}