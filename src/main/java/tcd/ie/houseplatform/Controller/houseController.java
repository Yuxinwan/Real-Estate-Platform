package tcd.ie.houseplatform.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcd.ie.houseplatform.Service.houseService;
import org.springframework.beans.factory.annotation.Autowired;
import tcd.ie.houseplatform.domain.House;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class houseController {
    @Autowired
    private houseService houseService;

    @GetMapping("/getAllHouse")
    public List<House> getAll(){
        return houseService.getAllproperties();
    }

    @GetMapping("/id")
    public ResponseEntity<House> getHouseById(@PathVariable Long id){
        House house = houseService.getPropertyById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id " + id));
        return ResponseEntity.ok(house);
    }

    @PostMapping("/addHouse")
    public House createHouse(@RequestBody House house){
        return houseService.createProperty(house);
    }

    @PutMapping("/id")
    public ResponseEntity<House> updateProperty(@PathVariable Long id, @RequestBody House houseDetails){
        House updatedHouse = houseService.updateProperty(id, houseDetails);
        return ResponseEntity.ok(updatedHouse);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id){
        houseService.deleteProperty(id);
        return ResponseEntity.ok().build();

    }





}
