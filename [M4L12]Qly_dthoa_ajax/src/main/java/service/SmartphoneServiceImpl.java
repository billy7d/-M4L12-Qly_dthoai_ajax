package service;

import model.Smartphone;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SmartphoneRepository;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findOne(Integer id) {
        return smartphoneRepository.findOne(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public Smartphone delete(Integer id) {
        Smartphone smartPhone = smartphoneRepository.findOne(id);
        smartphoneRepository.delete(id);
        return smartPhone;
    }

  
}
