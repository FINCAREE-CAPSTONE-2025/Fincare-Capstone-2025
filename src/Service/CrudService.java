package service;

import java.util.List;

public interface CrudService<Tipe, ID> {
    Tipe tambah(Tipe t);
    Tipe temukan(ID id);
    List<Tipe> temukanSemua();
    Tipe perbarui(Tipe t);
    boolean hapus(ID id);
}
