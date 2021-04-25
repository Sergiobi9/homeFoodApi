package obi.sergi.homefood.Controllers.ItemLocation;

import obi.sergi.homefood.Entities.ItemLocation.ItemLocation;
import obi.sergi.homefood.Entities.ItemLocation.ItemLocationRegisterSimplified;
import obi.sergi.homefood.Entities.ItemLocation.ItemLocationSimplified;
import obi.sergi.homefood.Repositories.ItemLocation.ItemLocationRepository;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static obi.sergi.homefood.Utils.Response.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/item/location")
public class ItemLocationController {

    @Autowired
    private ItemLocationRepository itemLocationRepository;

    @GetMapping("/all/familyId/{familyId}")
    public ResponseEntity getFamilyItemLocations(@PathVariable String familyId) {
        List<ItemLocation> itemLocations = itemLocationRepository.findItemLocationsByFamilyId(familyId);
        List<ItemLocationSimplified> itemLocationsToReturn = new ArrayList<>();

        for (ItemLocation itemLocation : itemLocations){
            itemLocationsToReturn.add(new ItemLocationSimplified(itemLocation));
        }

        return new ResponseEntity(itemLocationsToReturn, HttpStatus.valueOf(200));
    }

    @PostMapping("/register/name")
    public ResponseEntity registerItemLocationName(@RequestBody ItemLocationRegisterSimplified itemLocationRegisterSimplified) {
        String itemLocationName = itemLocationRegisterSimplified.getName();
        ItemLocation itemLocation = itemLocationRepository.findItemLocationByName(itemLocationName);

        if (itemLocation == null){
            itemLocation = new ItemLocation(itemLocationRegisterSimplified);
            itemLocationRepository.save(itemLocation);
            return new ResponseEntity(new ItemLocationSimplified(itemLocation), HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(200));
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerItemLocation(@RequestBody ItemLocation itemLocation) {
        Map<Object, Object> model = new HashMap<>();

        String itemLocationName = itemLocation.getName();
        ItemLocation itemLocationToCheck = itemLocationRepository.findItemLocationByName(itemLocationName);

        if (itemLocationToCheck != null){
            model.put(Response.INFO, ITEM_LOCATION_EXISTS);
            return new ResponseEntity(model, HttpStatus.valueOf(200));
        }

        itemLocationRepository.save(itemLocation);

        model.put(Response.INFO, SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }


}
