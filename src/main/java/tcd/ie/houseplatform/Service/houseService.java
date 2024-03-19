package tcd.ie.houseplatform.Service;

import tcd.ie.houseplatform.Repo.houseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcd.ie.houseplatform.domain.House;

import java.util.List;
import java.util.Optional;
@Service
public class houseService {

    @Autowired
    private houseRepo houseRepo;

    public List<House> getAllproperties(){
        return houseRepo.findAll();
    }

    public Optional<House> getPropertyById(Long id) {
        return houseRepo.findById(id);
    }

    public House createProperty(House house) {
        return houseRepo.save(house);
    }


    public House updateProperty(Long id, House propertyDetails) {
        House property = houseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id " + id));

        property.setTitle(propertyDetails.getTitle());
        property.setAddress(propertyDetails.getAddress());
        property.setPrice(propertyDetails.getPrice());
        property.setBedrooms(propertyDetails.getBedrooms());
        property.setBathrooms(propertyDetails.getBathrooms());
        return houseRepo.save(property);
    }

    public void deleteProperty(Long id) {
        House house = houseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id " + id));
        houseRepo.delete(house);
    }
















































}








