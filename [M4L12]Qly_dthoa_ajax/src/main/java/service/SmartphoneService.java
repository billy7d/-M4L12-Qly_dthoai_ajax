package service;

import model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findOne(Integer id);
    Smartphone save(Smartphone smartPhone);
    Smartphone delete(Integer id);


}
